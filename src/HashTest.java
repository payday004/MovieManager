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
    /**
     * Sets up the tests that follow.
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Test the hash function
     */
    public void testh() {
        
        int maxSize  = 500; 
        
        Hash<String, String> myHash = new Hash<String, String>(maxSize);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("aaaabbb", 101), 1640219587 % 101);
    }
}