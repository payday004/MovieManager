/**
 * Hash class
 * 
 * @author Peyton Dexter and Justin Shelton
 * @version 12/7/2021
 *
 * @param <T>
 *            data
 * @param <K>
 *            key
 */
public class Hash<T, K> implements HashADT<T, K> {

    // ~ Fields
    // .............................................................
    private int maxCapacity;
    private int usage;

    private T[] hT;

    // ~ Constructor
    // ............................................................
    /**
     * hash table contructor
     * 
     * @param maxCapacity
     *            inital maximum capacity of hash table
     */
    @SuppressWarnings("unchecked")
    public Hash(int maxCapacity) {

        this.maxCapacity = maxCapacity;

        this.usage = 0;

        hT = (T[])new Object[maxCapacity];

    }


    // ~ Public Methods
    // ............................................................
    /**
     * implementation of put method as described in HashADT
     */
    @Override
    public boolean put(T inElem) {

        // need to double size check
        if (usage >= maxCapacity / 2) {
            hT = doubleSize();

            System.out.println("Name hash table size doubled to " + maxCapacity
                + " slots.");
        }

        // get location from key
        int location = h(inElem.toString(), maxCapacity);

        // duplicate check
        if (hT[location] != null && hT[location].equals(inElem)) {
            return false;
        }

        // somehTing already exists
        if (hT[location] != null) {

            // System.out.println("TIME TO PROBE");

            // quadradic probe
            int probe = 0;
            while (hT[(location + probe * probe) % maxCapacity] != null) {
                // inc probe
                probe++;

                // duplicate check
                if (hT[(location + probe * probe) % maxCapacity] != null
                    && hT[(location + probe * probe) % maxCapacity].equals(
                        inElem)) {
                    // System.out.println("DUPLICATE");

                    return false;
                }

            }

            // insert element and update usage
            hT[(location + probe * probe) % maxCapacity] = inElem;
            usage++;

            return true;
        }

        // insert into hash table + update usage
        else {
            hT[location] = inElem;
            usage++;
            return true;
        }
    }


    /**
     * implementation of get method as described in HashADT
     */
    @Override
    public T get(K key) {

        // get location
        int location = h((String)key, maxCapacity);

        // doesnt exist -> return null
        if (hT[location] == null) {
            return null;
        }

        // exists but not same element -> colision resolution
        if (hT[location].toString() != key) {

            // probe
            int probe = 0;
            // while current position != null and != key (target)
            while (hT[(location + probe * probe) % maxCapacity] != null
                && !hT[(location + probe * probe) % maxCapacity].toString()
                    .equals(key)) {
                // inc probe
                probe++;
            }

            // if found key
            if (hT[(location + probe * probe) % maxCapacity] != null
                && hT[(location + probe * probe) % maxCapacity].toString()
                    .equals(key)) {

                // return element
                return hT[(location + probe * probe) % maxCapacity];
            }

            // does not exist
            else {
                return null;
            }
        }

        // exists and correct element
        else {
            return hT[location];
        }
    }


    /**
     * removes an element from hash table
     * 
     * @param key
     *            key of element to be removed
     * @return element that was removed, null if nothing removed
     */
    public T remove(K key) {

        // get location
        int location = h((String)key, maxCapacity);

        // null check nothing to be removed
        if (hT[location] == null) {
            // System.out.println("THIS DOES NOT EXIST");
            return null;
        }

        // exists but not same element -> colision resolution
        if (hT[location].toString() != key) {
            // System.out.println("COLISION RESOLUTION");

            // probe
            int probe = 0;
            // while current position != null and != key (target)
            while (hT[(location + probe * probe) % maxCapacity] != null
                && !hT[(location + probe * probe) % maxCapacity].toString()
                    .equals(key)) {
                // inc probe
                probe++;
            }

            // if found key
            if (hT[(location + probe * probe) % maxCapacity] != null
                && hT[(location + probe * probe) % maxCapacity].toString()
                    .equals(key)) {
                // copy element
                T outElement = hT[(location + probe * probe) % maxCapacity];
                // remove element
                hT[(location + probe * probe) % maxCapacity] = null;
                usage--;
                // rehash
                hT = rehash();
                // return
                return outElement;
            }

            // does not exist
            else {
                return null;
            }

        }

        // exists and correct element
        else {
            // copy
            T element = hT[location];
            // remove
            hT[location] = null;
            usage--;
            // rehash
            hT = rehash();
            // return
            return element;
        }
    }


    /**
     * updates an element
     * 
     * @param key
     *            the key of the element to be updated
     * @param elem
     *            the element to replace it with
     * @return true if updated, flase if not
     */
    public boolean update(K key, T elem) {

        // get location
        int location = h((String)key, maxCapacity);

        // null check nothing to be removed
        if (hT[location] == null) {
            // System.out.println("THIS DOES NOT EXIST");
            return false;
        }

        // exists but not same element -> colision resolution
        if (hT[location].toString() != key) {
            // System.out.println("COLISION RESOLUTION");

            // probe
            int probe = 0;
            // while current position != null and != key (target)
            while (hT[(location + probe * probe) % maxCapacity] != null
                && !hT[(location + probe * probe) % maxCapacity].toString()
                    .equals(key)) {
                // inc probe
                probe++;
            }

            // if found key
            if (hT[(location + probe * probe) % maxCapacity] != null
                && hT[(location + probe * probe) % maxCapacity].toString()
                    .equals(key)) {

                // update element
                hT[(location + probe * probe) % maxCapacity] = elem;

                return true;
            }

            // does not exist
            else {
                return false;
            }

        }

        // exists and correct element
        else {
            // update and return
            hT[location] = elem;
            return true;
        }
    }


    /**
     * implementation of doubleSize method as described in HashADT
     */
    @Override
    public T[] doubleSize() {

        // System.out.println("DOUBLE SIZE");

        // temp hash object
        Hash<T, K> outHash = new Hash<T, K>(maxCapacity * 2);

        // for all elements in old array
        for (int i = 0; i < hT.length; i++) {
            // if not null
            if (hT[i] != null) {

                // add to new hash
                outHash.put(hT[i]);
            }
        }

        // update max capacity
        maxCapacity = maxCapacity * 2;

        // return array
        return outHash.hT;
    }


    /**
     * override of object to string
     */
    @Override
    public String toString() {

        // return string
        String outStr = "";
        // System.out.println("max capacity: " + hT.length);
        // System.out.println("Total records: " + usage);

        // for each element in hT add to string
        for (int i = 0; i < hT.length; i++) {
            // null check
            if (hT[i] != null) {
                outStr = outStr + "|" + hT[i].toString() + "| " + i + "\n";
            }
        }
        outStr = outStr + "Total records: " + usage;
        return outStr;
    }


    // ~ Hash Function
    // ............................................................
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


    // ~ Private Functions
    // ............................................................
    /**
     * rehashes all the elements in array
     * 
     * @return the array of rehashed elemetns
     */
    private T[] rehash() {

        // temp hash object
        Hash<T, K> outHash = new Hash<T, K>(maxCapacity);

        // for all elements in old array
        for (int i = 0; i < hT.length; i++) {
            // if not null
            if (hT[i] != null) {

                // add to new hash
                outHash.put(hT[i]);
            }
        }

        // return array
        return outHash.hT;
    }

}
