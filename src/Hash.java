/**
 * Stub for hash table class. Extend with your code, and update this docblock
 *
 * @author Peyton Dexter 
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
    @Override
    public boolean put() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T[] doubleSize() {
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
