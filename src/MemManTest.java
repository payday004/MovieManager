import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Test the main function (you should throw this away for your project and write
 * your own tests)
 * 
 * @author Justin Shelton and Peyton Dexter
 * @version 12.2.2021
 */
public class MemManTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     * @throws FileNotFoundException 
     */
    public void testRInit() throws FileNotFoundException {
        MemMan manager = new MemMan();
        assertNotNull(manager);
        String[] str = new String[1];
        str[0] = "sampleInput.txt";
        MemMan.main(0, 0, str);
    }
}