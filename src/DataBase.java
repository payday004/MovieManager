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
        
        hashTable = new Hash<Record, String>(hashSize); 

    }
    
    
    // ~ Public Methods  ............................................................
    /**
     * 
     */
    public void add(Record inRecord) {
        
        hashTable.put(inRecord); 

    }
    
    
    /**
     * 
     */
    public void delete(Record inRecord) {
        
        System.out.println(hashTable.remove(inRecord.toString()));
        

    }
    
    
    /**
     * 
     */
    public void updateAdd() {

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
