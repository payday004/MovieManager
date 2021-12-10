/**
 * holds the handle of a record
 * @author Justin Shelton and Peyton Dexter
 * @version 12.9.2021
 */
public class Handle {

    private int position;
    private int length;
    
    /**
     * constructor to set up handle
     * @param pos position in memory
     * @param len length of string
     */
    public Handle(int pos, int len) {
        position = pos;
        length = len;
    }
    
    /**
     * getter for position
     * @return int position
     */
    public int getPos() {
        return position;
    }
    
    /**
     * getter for length
     * @return int length of string
     */
    public int getLength() {
        return length;
    }
}
