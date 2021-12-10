import java.io.FileNotFoundException;
import student.TestCase;

/**
 * tests the free block parts
 * 
 * @author Justin Shelton and Peyton Dexter
 * @version 12.8.2021
 */
public class FreeBlocksTest extends TestCase {

    public void testFreeBlockCase() throws FileNotFoundException {
        MemMan manager = new MemMan();
        assertNotNull(manager);
        String[] str = new String[3];
        str[0] = "32";
        str[1] = "10";
        str[2] = "FreeBlockTest.txt";

        MemMan.main(str);
    }
}
