import student.TestCase;

/**
 * tests the handle parts
 * 
 * @author Justin Shelton and Peyton Dexter
 * @version 12.9.2021
 */
public class HandleTest extends TestCase {
    
    private Handle han = new Handle(10, 20);
    
    /**
     * tests the handle getters
     */
    public void testHandle() {
        assertEquals(han.getLength(), 20);
        assertEquals(han.getPos(), 10);
    }
}
