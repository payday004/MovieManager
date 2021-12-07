/**
 * 
 * @author pd_de
 *
 */
public class DataBase {
    
    // ~ Fields ............................................................
    private Hash<Record, String> hashTable; 
    
    
    // ~ Constructor ............................................................
    /**
     * 
     */
    public DataBase(int hashSize, int memSize) {
        // hashtable
        hashTable = new Hash<Record, String>(hashSize); 
    }
    
    
    // ~ Public Methods  ............................................................
    /**
     * 
     */
    public void add(Record inRecord) {
        //hash table add 
        hashTable.put(inRecord); 
    }
    
    
    /**
     * 
     */
    public void delete(Record inRecord) {
        //hash table remove
        hashTable.remove(inRecord.toString());
    }
    
    
    /**
     * 
     */
    public void updateAdd(String[] inArray) {

        // element exists check
        if(hashTable.get(inArray[0]) != null) {
            
            //get copy of data from hash
            Record tempRecord = hashTable.get(inArray[0]); 
            //add KVPair to record
            tempRecord.updateData(new KVPair<String, String>(inArray[1], inArray[2])); 
            //update the record in the hash table
            hashTable.update(tempRecord.toString(), tempRecord);  
        }
        
        // else element doesnt exist in database
        else {
            System.out.println("THIS DOES NOT EXIST IN THE DATABASE"); 
        }
    }
    
    
    /**
     * 
     */
    public void updateDelete() {

    }
    
    
    /**
     * 
     */
    public void printHash() {
        System.out.println(hashTable); 
    }
    
    
    /**
     * 
     */
    public void printBlocks() {

    }
    
}
