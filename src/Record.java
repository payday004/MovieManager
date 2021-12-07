import java.util.ArrayList;

/**
 * record class
 * @author Peyton Dexter and Justin Shelton
 * @version 12.2.2021
 */
public class Record {
    
    
    // ~ Fields ............................................................
    private String name; 
    
    private ArrayList<KVPair<String, String>> data; 

    
    // ~ Constructor ............................................................
    /**
     * constructor for record
     * @param inData record data
     */
    public Record(String name) {
        this.name = name;
        data = new ArrayList<KVPair<String, String>>(); 
    }
    
    
    // ~ Public Methods ...........................................................
    /**
     * returns the records data as a string
     * @return string
     */
    @Override
    public String toString() {
        return name;
    }
    
    
    /**
     * returns the records data as a string
     * @return string
     */
    public void updateData(KVPair<String,String> inPair) {
        //add the input
        data.add(inPair); 
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
            return name.equals(otherR.name);
        }
        return false;
    }
    
}
