import student.TestCase;

/**
 * tests the block
 * @author Justin Shelton and Peyton Dexter
 * @version 12.9.2021
 */
public class BlockTest extends TestCase {
    
    private Block b = new Block(2);
    
    /**
     * tests the block position getter
     */
    public void testBlock() {
        assertEquals(b.getPosition(), 2);
    }
}
