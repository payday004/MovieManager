/**
 * 
 * @author Justin Shelton and Peyton Dexter
 * @version 12.2.2021
 * @param <T> element
 * @param <K> key
 */
public interface HashADT<T, K> {

    /**
     * inserts element in to hash table
     * @param inElem element to be inserted 
     * @return true if inserted
     */
    public boolean put(T inElem);


    /**
     * gets element from hash table given key
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
