/**
 * data base class
 * 
 * @author pd_de
 * @version 12/7/2021
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
        // if added
        if (hashTable.put(inRecord)) {
            System.out.println("|" + inRecord.toString() + "|"
                + " has been added to the Name dataBase. ");
        }
        // if not added
        else {
            System.out.println("|" + inRecord.toString() + "|"
                + " duplicates a record already in the Name database. ");
        }
    }


    /**
     * deletes record form data base
     * 
     * @param inRecord
     *            record to be deleted
     */
    public void delete(Record inRecord) {
        // hash table remove
        // if removed
        if (hashTable.remove(inRecord.toString()) != null) {
            System.out.println("|" + inRecord.toString() + "|"
                + " has been deleted from the Name database. ");
        }
        // not removed
        else {
            System.out.print("|" + inRecord.toString() + "|");
            System.out.print(" not deleted becuase it does not exist");
            System.out.println(" in the Name database.");
        }
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

            System.out.println("Updated Record: " + tempRecord.fullString());
        }

        // else element doesnt exist in database
        else {
            System.out.print("|" + inArray[0] + "|");
            System.out.print(" has been updated becuase it does ");
            System.out.println("not exist in the Name database. ");
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
            // System.out.println("DB UPDATE DELETE");

            // get copy of data from hash
            Record tempRecord = hashTable.get(inArray[0]);
            // remove kv pair from record data
            boolean flag = tempRecord.removeData(inArray[1]);

            if (flag) {
                // update the record in the hash table
                hashTable.update(tempRecord.toString(), tempRecord);
                System.out.println("Updated Record: " + tempRecord
                    .fullString());
            }
            else {
                System.out.print("|" + inArray[0] + "|"
                    + " not updated because the field ");
                System.out.println("|" + inArray[1] + "|" + " does not exist");
            }

        }
        // else the element does not exist in the database
        else {
            System.out.print("|" + inArray[0] + "|");
            System.out.print(" not updated becuase it does not ");

            System.out.println("exist in the Name database.");
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
        System.out.println("");
    }

}
