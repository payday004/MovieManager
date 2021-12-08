/**
 * hash abstract data type
 * 
 * @author pd_de
 *
 * @param <T>
 *            data
 * @param <K>
 *            key
 */
public interface HashADT<T, K> {

    /**
     * puts elemnt into hash table
     * 
     * @param inElem
     *            element to be placed in table
     * @return true if inserted, false if not
     */
    public boolean put(T inElem);


    /**
     * get an element with corresponding key from hash table
     * 
     * @param key
     *            key of element to be retrieved
     * @return the corresponding element
     */
    public T get(K key);


    /**
     * doubles size of array
     * 
     * @return doubled size of array
     */
    public T[] doubleSize();

}
