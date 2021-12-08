import student.TestCase;

/**
 * Record test class
 * 
 * @author pd_de
 * @version 12/7/2021
 *
 */
public class RecordTest extends TestCase {

    private Record hello;

    private Record equalsTest;

    /**
     * Sets up the tests that follow.
     */
    public void setUp() {

        hello = new Record("hello");

        hello.updateData(new KVPair<String, String>("hello", "hello"));

        equalsTest = new Record("SAME");
    }


    /**
     * Test the update data function
     */
    public void testUpdateData() {

        hello.updateData(new KVPair<String, String>("hey", "hey"));
        assertTrue(equalsTest.equals(equalsTest));
    }


    /**
     * Test the remove data function
     */
    public void testRemoveData() {

        hello.removeData("hello");

        hello.removeData("hey");
        assertTrue(equalsTest.equals(equalsTest));
    }


    /**
     * Test the tostring function
     */
    public void testToString() {

        assertTrue(equalsTest.equals(equalsTest));
        System.out.println(hello.toString());
    }


    /**
     * Test the equals function
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals() {

        // an instance
        assertTrue(equalsTest.equals(equalsTest));
        // null
        assertFalse(equalsTest.equals(null));
        // not a KVPair
        assertFalse(equalsTest.equals("Not KVPair"));
        // KVPair but not equal
        assertFalse(equalsTest.equals(new Record("a")));

        // same
        assertTrue(equalsTest.equals(new Record("SAME")));

    }

}
