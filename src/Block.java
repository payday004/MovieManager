/**
 * block holds the position of an object in memory
 * 
 * @author Justin Shelton and Peyton Dexter
 * @version 12.9.2021
 */
public class Block {

    private int position;

    /**
     * Constructor to set up block position
     * 
     * @param p
     *            position
     */
    public Block(int p) {
        position = p;
    }


    /**
     * getter for block position
     * 
     * @return int
     */
    public int getPosition() {
        return position;
    }
}
