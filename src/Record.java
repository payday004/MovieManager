import java.util.ArrayList;

/**
 * record class
 * 
 * @author Peyton Dexter and Justin Shelton
 * @version 12.2.2021
 */
public class Record {

    // ~ Fields ............................................................
    private String name;

    private ArrayList<KVPair<String, String>> data;

    // ~ Constructor
    // ............................................................
    /**
     * constructor for record
     * 
     * @param inData
     *            record data
     */
    public Record(String name) {
        this.name = name;
        data = new ArrayList<KVPair<String, String>>();
    }


    // ~ Public Methods
    // ...........................................................
    /**
     * override of object to string
     */
    @Override
    public String toString() {
        return name;
    }
    
    
    
    /**
     * override of object to string
     */
    public String fullString() {
        String outStr = ""; 
        
        outStr += "|"; 
        
        outStr += name; 
        
        for(int i = 0; i < data.size(); i++) {
            outStr += "<SEP>" + data.get(i).key() + "<SEP>" + data.get(i).value(); 
        }
        
        outStr += "|";
        
        return outStr;
    }

    

    /**
     * Adds KVPair to data
     * 
     * @param inPair
     *            pair to be added
     */
    public void updateData(KVPair<String, String> inPair) {
        // add the input
        
        data.removeIf(i -> i.key().equals(inPair.key()));
        
        data.add(inPair);
    }


    /**
     * removes KVpair from data if the key matches the inString
     * 
     * @param inString
     *            key to be removed
     * @return true if KVPair is removed
     */
    public boolean removeData(String inString) {
        // remove if keys match
        return data.removeIf(i -> i.key().equals(inString));
    }


    /**
     * override of object equals method
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
