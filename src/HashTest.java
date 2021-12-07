import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test the hash function (you should throw this away for your project and write
 * your own tests)
 *
 * @author Justin Shelton and Peyton Dexter
 * @version 12.2.2021
 */
public class HashTest extends TestCase {
    
    
    private Hash<Record, String> hashTable; 
    
    /**
     * Sets up the tests that follow.
     */
    public void setUp() {
        // Nothing Here
        hashTable = new Hash<Record, String>(4); 
    }


    /**
     * Test the hash function
     */
    public void testh() {
        
        int maxSize  = 500; 
        
        Hash<String, String> myHash = new Hash<String, String>(maxSize);
        assertEquals(myHash.h("aaaabbbb", 101), 75);
        assertEquals(myHash.h("aaaabbb", 101), 1640219587 % 101);
    }
    
    
    /**
     * 
     */
    public void testPut() {
        
        Record record1 = new Record("test record 1"); 
        Record record2 = new Record("test record 2"); 
        Record record3 = new Record("test record 3"); 
        Record record4 = new Record("test record 4"); 
        Record record5 = new Record("test record 5"); 
        
        hashTable.put(record1); 
        
        System.out.println(hashTable); 
        System.out.println("\n"); 
        
        hashTable.put(record2); 
        
        System.out.println(hashTable); 
        System.out.println("\n"); 
        
        hashTable.put(record3);
        
        System.out.println(hashTable); 
        System.out.println("\n"); 
        
        
        hashTable.put(record4);
        
        System.out.println(hashTable); 
        System.out.println("\n"); 
        
        hashTable.put(record5);
        
        System.out.println(hashTable); 
        System.out.println("\n"); 
        
        
        
    }
    
    
    /**
     * 
     */
    public void testGet() {
        
        
        Record record1 = new Record("test record 1"); 
        Record record2 = new Record("test record 2"); 
        Record record3 = new Record("test record 3"); 
        
        hashTable.put(record1); 
        hashTable.put(record2); 
        hashTable.put(record3);
        
        assertEquals(hashTable.get(record1.toString()), record1); 
        
        assertEquals(hashTable.get("hello"), null); 
    }
    
    
}