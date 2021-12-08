/**
 * 
 * @author pd_de
 *
 */
public class DataBase {

    // ~ Fields ............................................................
    private Hash<Record, String> hashTable;

    // ~ Constructor
    // ............................................................
    /**
     * data base object to bundle hashTable and block of memory
     * 
     * @param hashSize
     *            inital hash size
     * @param memSize
     *            initial block of mem size
     */
    public DataBase(int hashSize, int memSize) {
        // hashtable
        hashTable = new Hash<Record, String>(hashSize);
    }


    // ~ Public Methods
    // ............................................................
    /**
     * adds record to database
     * 
     * @param inRecord
     *            record to be added
     */
    public void add(Record inRecord) {
        // hash table add
        hashTable.put(inRecord);
    }


    /**
     * deletes record form data base
     * 
     * @param inRecord
     *            record to be deleted
     */
    public void delete(Record inRecord) {
        // hash table remove
        hashTable.remove(inRecord.toString());
    }


    /**
     * updates the record in the database
     * 
     * @param inArray
     *            array of info such that
     *            index 0 is the element to be changed
     *            index 1 is the field_name
     *            index 2 is the field_value
     */
    public void updateAdd(String[] inArray) {

        // element exists check
        if (hashTable.get(inArray[0]) != null) {

            // get copy of data from hash
            Record tempRecord = hashTable.get(inArray[0]);
            // add KVPair to record
            tempRecord.updateData(new KVPair<String, String>(inArray[1],
                inArray[2]));
            // update the record in the hash table
            hashTable.update(tempRecord.toString(), tempRecord);
        }

        // else element doesnt exist in database
        else {
            System.out.println("THIS DOES NOT EXIST IN THE DATABASE");
        }
    }


    /**
     * updates record in database based on delete behaviors
     * 
     * @param inArray
     *            array of info such that
     *            index 0 is the element to be changed
     *            index 1 is the field_name
     *            index 2 is the field_value
     */
    public void updateDelete(String[] inArray) {

        // element exists check
        if (hashTable.get(inArray[0]) != null) {
            System.out.println("DB UPDATE DELETE");

            // get copy of data from hash
            Record tempRecord = hashTable.get(inArray[0]);
            // remove kv pair from record data
            boolean flag = tempRecord.removeData(inArray[1]);

            if (flag) {
                // update the record in the hash table
                hashTable.update(tempRecord.toString(), tempRecord);
            }
            else {
                System.out.println(
                    "THIS SPECIFIC KEY WAS NOT PRESENT IN RECORD");
            }

        }
        // else the element does not exist in the database
        else {
            System.out.println("DOES NOT EXIST IN DATA BASE");
        }

    }


    /**
     * prints hash table
     */
    public void printHash() {
        System.out.println(hashTable);
    }


    /**
     * prints blocks of memory
     */
    public void printBlocks() {

    }

}
