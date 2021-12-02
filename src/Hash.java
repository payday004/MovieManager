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
        // TODO Auto-generated method stub
        
        //get key
        int location = h(inElem.toString(), maxCapacity); 
        
        //if it already exists
        if(HT[location].equals(inElem)) {
            System.out.println("this is a duplicate"); 
        }
        //insert into hash table
        else {
            HT[location] = inElem; 
        }
        
        return false;
    }

    
    /**
     * 
     */
    @Override
    public T get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] doubleSize() {
        
        T[] newArray = (T[])new Object[maxCapacity * 2];
        
        System.out.println(newArray); 
        
        // TODO Auto-generated method stub
        return null;
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





}
