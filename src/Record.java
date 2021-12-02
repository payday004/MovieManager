/**
 * record class
 * @author pd_de
 *
 */
public class Record {
    
    // ~ Fields ............................................................
    private String data; 

    
    // ~ Constructor ............................................................
    /**
     * 
     * @param inData
     */
    public Record(String inData) {
        this.data = inData; 
    }
    
    // ~ Public Methods ............................................................
    
    /**
     * 
     */
    @Override
    public String toString() {
        return data; 
    }
    
}
