import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the hash function (you should throw this away for your project and write
 * your own tests)
 *
 * @author Justin Shelton and Peyton Dexter
 * @version 12.2.2021
 */
public class HashTest extends TestCase {

    private Hash<Record, String> hashTable;
    private Hash<Record, String> removeHash;

    private Record record1;
    private Record record2;
    private Record record3;

    private Record hello;
    private Record ok;
    private Record hi;

    /**
     * Sets up the tests that follow.
     */
    public void setUp() {
        // Nothing Here
        hashTable = new Hash<Record, String>(4);

        removeHash = new Hash<Record, String>(8);

        record1 = new Record("Can You Handle?");
        record2 = new Record("Another Test");
        record3 = new Record("Death Note");

        ok = new Record("ok");
        hello = new Record("hello");
        hi = new Record("hi");

    }


    /**
     * Test the hash function
     */
    public void testh() {

        int maxSize = 500;

        Hash<String, String> myHash = new Hash<String, String>(maxSize);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("aaaabbb", 101), 1640219587 % 101);

        // System.out.println(myHash.h("hello", 8)); //7
        // System.out.println(myHash.h("hi", 8));
        // System.out.println(myHash.h("ok", 8)); //7
        // System.out.println(myHash.h("boom", 8));
        // System.out.println(myHash.h("another", 8));
    }


    /**
     * 
     */
    public void testPut() {

        // normal cases
        hashTable.put(record3);
        hashTable.put(record2);

        // probe input
        hashTable.put(record1);

        // duplicate
        hashTable.put(record1);

        // System.out.println(hashTable);

        assertEquals(hashTable.get(record1.toString()), record1);

    }


    /**
     * 
     */
    public void testGet() {

        hashTable.put(record1);
        hashTable.put(record3);

        // System.out.println(hashTable);

        assertEquals(hashTable.get(record1.toString()), record1);

        assertEquals(hashTable.get(record2.toString()), null);

        assertEquals(hashTable.get("hello"), null);
    }


    /**
     * 
     */
    public void testRemove() {

        removeHash.put(hello);
        removeHash.put(ok);
        removeHash.put(hi);

        System.out.println(removeHash);

        // probe and correct element
        removeHash.remove("hi");

        System.out.println(removeHash);

        // location null
        removeHash.remove("boom");

        // has to probe but doestn exist
        removeHash.remove("hi");

        // exists and correct
        removeHash.remove("ok");

        // System.out.println(removeHash);

    }


    /**
     * 
     */
    public void testUpdate() {

        Record boom = new Record("boom");

        removeHash.put(hello);
        removeHash.put(ok);
        removeHash.put(hi);

        System.out.println(removeHash);

        // probe and correct element
        removeHash.update("hi", hi);
        removeHash.remove("hi");

        System.out.println(removeHash);

        // location null
        removeHash.update("boom", boom);

        // has to probe but doestn exist
        removeHash.update("hi", hi);

        // exists and correct
        removeHash.update("ok", ok);

    }

}
