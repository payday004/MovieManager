
public interface HashADT<T, K> {
    /**
     * put element into hash table
     * 
     * @return Returns true element was inserted
     */
    public boolean put();


    /**
     * 
     * @param key
     * @return the element represented by the key
     */
    public T get(K key);


    /**
     * rehashes all the elements in the hash table into a hash table twice the
     * size
     * 
     * @return the table that is twice the size with all elements
     */
    public T[] doubleSize();

}
