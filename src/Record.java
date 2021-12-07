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
    
    
    /**
     * 
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() == this.getClass()) {
            Record otherR = (Record)o;
            return data.equals(otherR.data);
        }
        return false;
    }
    
}
