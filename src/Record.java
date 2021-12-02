/**
 * record class
 * @author Peyton Dexter and Justin Shelton
 * @version 12.2.2021
 */
public class Record {
    
    // ~ Fields ............................................................
    private String data; 

    
    // ~ Constructor ............................................................
    /**
     * constructor for record
     * @param inData record data
     */
    public Record(String inData) {
        this.data = inData; 
    }
    
    // ~ Public Methods ............................................................
    
    /**
     * returns the records data as a string
     * @return string 
     */
    @Override
    public String toString() {
        return data; 
    }
    
}
