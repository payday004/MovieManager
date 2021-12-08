/**
 * KVPair class
 * 
 * @author pd_de
 * @version 12.7.2021
 *
 * @param <K>
 *            key
 * @param <V>
 *            value
 */
public class KVPair<K, V> {

    // ~ Fields ............................................................

    private K key;

    private V value;

    // ~ Constructor .......................................................
    /**
     * Create a KVPair object with the specified parameters.
     * 
     * @param inKey
     *            is the key
     * @param inValue
     *            is the value
     */
    public KVPair(K inKey, V inValue) {

        key = inKey;
        value = inValue;
    }


    // ~ Public Methods .....................................................
    /**
     * Get key.
     * 
     * @return key
     */
    public K key() {
        return key;

    }


    /**
     * Get value.
     * 
     * @return value
     */
    public V value() {
        return value;
    }

}
