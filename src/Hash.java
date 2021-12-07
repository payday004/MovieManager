/**
 * Stub for hash table class. Extend with your code, and update this docblock
 *
 * @author Peyton Dexter and Justin Shelton
 * @version 12/1/2021
 */

public class Hash<T, K> implements HashADT<T, K> {
    
    // ~ Fields ............................................................
    private int maxCapacity; 
    private int usage; 
    
    private T[] HT; 
    

    // ~ Constructor ............................................................
    /**
     * Create a new Hash object.
     * 
     */
    @SuppressWarnings("unchecked")
    public Hash(int maxCapacity) {
        
        this.maxCapacity = maxCapacity; 
        
        this.usage = 0; 
        
        HT = (T[])new Object[maxCapacity];
        
    }

    // ~ Getters and Setters  ............................................................
    /**
     * @return usage 
     */
    public int getUsage() {
        return usage; 
    }
    
    /**
     * @return maxCapacity
     */
    public int getMaxCap() {
        return maxCapacity; 
    }

    
    // ~ Public Methods  ............................................................
    /**
     * 
     */
    @Override
    public boolean put(T inElem) {
        
        //get location from key 
        int location = h(inElem.toString(), maxCapacity); 
        
        //System.out.println("location:  " +  location );
        
        //duplicate check
        if(HT[location] != null && HT[location].equals(inElem)) {
            //System.out.println("DUPLICATE");
            return false; 
        }
        
        //need to double size check
        if(usage >= maxCapacity/2) {
            HT = doubleSize(); 
        }
        

        //somehting already exists
        if(HT[location] != null) { 
            
            //System.out.println("TIME TO PROBE"); 
            
            //quadradic probe
            int probe = 0; 
            while(HT[(location + probe*probe) % maxCapacity] != null) { 
                probe++; 
            }
            
            //insert element and update usage 
            HT[(location + probe*probe) % maxCapacity] = inElem; 
            usage++; 

            return true; 
        }
        
        //insert into hash table + update usage
        else {
            HT[location] = inElem; 
            usage++; 
            return true; 
        }
    }

    
    
    /**
     * 
     */
    @Override
    public T get(K key) {
        
        //get location
        int location = h((String)key, maxCapacity); 
        
        // doesnt exist -> return null
        if(HT[location] == null) {
            return null; 
        }
        
        // exists but not same element -> colision resolution
        if(HT[location].toString() != key) {

            //probe
            int probe = 0; 
            //while current position != null and != key (target)  
            while(HT[(location + probe*probe) % maxCapacity] != null && !HT[(location + probe*probe) % maxCapacity].toString().equals(key)) {
                //inc probe
                probe++; 
            }
            
            
            //if found key
            if(HT[(location + probe*probe) % maxCapacity].toString().equals(key)) {
                
                //return element
                return HT[(location + probe*probe) % maxCapacity];
            }
            
            //does not exist
            else {
                return null; 
            }
        }
        
        // exists and correct element
        else {
            return HT[location]; 
        }
    }


    
    /**
     * 
     */
    public T remove(K key) {
        
        //get location
        int location = h((String)key, maxCapacity); 
        
        // null check nothing to be removed
        if(HT[location] == null) {
            //System.out.println("THIS DOES NOT EXIST");
            return null; 
        }
        
        // exists but not same element -> colision resolution
        if(HT[location].toString() != key) {
            //System.out.println("COLISION RESOLUTION");
            
            //probe
            int probe = 0; 
            //while current position != null and != key (target)  
            while(HT[(location + probe*probe) % maxCapacity] != null && !HT[(location + probe*probe) % maxCapacity].toString().equals(key)) {
                //inc probe
                probe++; 
                
                System.out.println(location); 
                System.out.println(probe*probe); 
                System.out.println(maxCapacity); 
                System.out.println((location + probe*probe) % maxCapacity); 
                System.out.println("\n"); 
                
            }
            
            
            //if found key
            if(HT[(location + probe*probe) % maxCapacity].toString().equals(key)) {
                //copy element
                T outElement = HT[(location + probe*probe) % maxCapacity];
                //remove element
                HT[(location + probe*probe) % maxCapacity] = null; 
                usage--; 
                //rehash
                HT = rehash(); 
                //return 
                return outElement; 
            }
            
            //does not exist
            else {
                return null; 
            }
            

        }
        
        // exists and correct element
        else {
            //copy 
            T element = HT[location]; 
            //remove
            HT[location] = null; 
            usage--; 
            //rehash
            HT = rehash(); 
            //return
            return element; 
        }
    }
    
    
    
    /**
     * 
     */
    public boolean update(K key, T elem) {
        
        //get location
        int location = h((String)key, maxCapacity); 
        
        // null check nothing to be removed
        if(HT[location] == null) {
            //System.out.println("THIS DOES NOT EXIST");
            return false; 
        }
        
        // exists but not same element -> colision resolution
        if(HT[location].toString() != key) {
            //System.out.println("COLISION RESOLUTION");
            
            //probe
            int probe = 0; 
            //while current position != null and != key (target)  
            while(HT[(location + probe*probe) % maxCapacity] != null && !HT[(location + probe*probe) % maxCapacity].toString().equals(key)) {
                //inc probe
                probe++; 
            }
            
            
            //if found key
            if(HT[(location + probe*probe) % maxCapacity].toString().equals(key)) {

                //update element
                HT[(location + probe*probe) % maxCapacity] = elem; 
                
                return true; 
            }
            
            //does not exist
            else {
                return false; 
            }
            

        }
        
        // exists and correct element
        else {
            //update and return
            HT[location] = elem; 
            return true; 
        }
    }
    

    
    /**
     * 
     */
    @Override
    public T[] doubleSize() {
        
        //System.out.println("DOUBLE SIZE"); 
        
        //temp hash object
        Hash<T, K> outHash = new Hash<T, K>(maxCapacity * 2); 

        //for all elements in old array 
        for(int i = 0; i < HT.length; i++) {
            //if not null
            if(HT[i] != null) {
                
                //add to new hash
                outHash.put(HT[i]);                   
            }
        }

        //update max capacity 
        maxCapacity = maxCapacity * 2; 
        
        //return array
        return outHash.HT;
    }
    
    
    
    /**
     * 
     */
    @Override
    public String toString() {
        
        //return string
        String outStr = "";
        System.out.println("max capacity:  " + HT.length); 
        System.out.println("usage       :  " + usage);
        
        //for each element in HT add to string
        for(int i = 0; i < HT.length; i++) {
            //null check
            if(HT[i] == null) {
                outStr = outStr + "null\n";                 
            }
            //add value
            else {
                outStr = outStr + HT[i].toString() + "\n"; 
            }             
        }
        return outStr; 
    }
    
    
    
    
    
    
    // ~ Hash Function  ............................................................
    /**
     * Compute the hash function. Uses the "sfold" method from the OpenDSA
     * module on hash functions
     *
     * @param s
     *            The string that we are hashing
     * @param m
     *            The size of the hash table
     * @return The home slot for that string
     */
    // You can make this private in your project.
    // This is public for distributing the hash function in a way
    // that will pass milestone 1 without change.
    public int h(String s, int m) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int)(Math.abs(sum) % m);
    }
    
    
    
    // ~ Private Functions  ............................................................
    /**
     * 
     * @return
     */
    private T[] rehash() {

        //temp hash object
        Hash<T, K> outHash = new Hash<T, K>(maxCapacity); 

        //for all elements in old array 
        for(int i = 0; i < HT.length; i++) {
            //if not null
            if(HT[i] != null) {
                
                //add to new hash
                outHash.put(HT[i]);                   
            }
        }

        //return array
        return outHash.HT;
    }





}
