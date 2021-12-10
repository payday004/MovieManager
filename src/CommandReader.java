import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The command reader parses through the command file and
 * makes calls to the hash table and memory based on
 * the commands given in the file.
 * 
 * @author Justin Shelton and Peyton Dexter
 * @version 12.1.2021
 */
public class CommandReader {

    /**
     * 
     * @param memSize
     *            size of initial block of memory
     * @param hashSize
     *            size of initial hash table
     * @param commandFile
     *            command file to be oppened
     * @throws FileNotFoundException
     *             if command file cant be found
     */
    public CommandReader(int memSize, int hashSize, File commandFile)
        throws FileNotFoundException {

        Scanner scan = new Scanner(commandFile);

        // database object
        DataBase dB = new DataBase(hashSize, memSize);

        // for each line in input file
        while (scan.hasNextLine()) {

            //dB.printBlocks();
            
            // split strings
            String command = scan.nextLine();
            String[] word = command.trim().split("\\s+", -2);

            // UPDATE COMMANDS
            if (word[0].contains("update")) {

                // UPDATE ADD
                if (word[1].contains("add")) {
                    // System.out.println(command.trim());

                    // pass to dB to handle implementation
                    dB.updateAdd(getUpdateInfo(word));
                }

                // UPDATE DELETE
                else {
                    // System.out.println(command.trim());

                    // pass to dB to handle implementation
                    dB.updateDelete(getUpdateInfo(word));
                }
            }

            // ADD COMMAND
            else if (word[0].contains("add")) {
                // System.out.println(command.trim());
                // System.out.println(getName(word));

                // add record into database
                dB.add(new Record(getName(word)));
            }

            // DELETE COMMAND
            else if (word[0].contains("delete")) {
                // System.out.println(command.trim());
                // System.out.println(getName(word));

                // delete record from database
                dB.delete(new Record(getName(word)));
            }

            // PRINT COMMANDS
            else if (word[0].contains("print")) {

                // PRINT HASHTEBLE
                if (word[1].contains("hashtable")) {
                    // echo command
                    // System.out.println(command.trim());
                    // print HashTable
                    dB.printHash();
                }

                // PRINT MEMORY BLOCK
                else {
                    // System.out.println(command.trim());
                    // System.out.println(command);
                    dB.printBlocks();
                }
            }
            //System.out.println("");
        }

        // close scanner
        scan.close();
    }


    /**
     * helper method to get Canonical Name
     * 
     * @param inArry
     * @return
     */
    private String getName(String[] inArry) {

        // return string
        String outStr = "";

        // for all string after add
        for (int i = 1; i < inArry.length; i++) {
            // add to return string
            outStr += inArry[i].trim() + " ";
        }

        // return string with leading and trailing white space removed
        return outStr.trim();
    }


    /**
     * 
     * @param inArry
     * @return output array where:
     *         index 0 is the element to be changed
     *         index 1 is the field_name
     *         index 2 is the field_value
     */
    private String[] getUpdateInfo(String[] inArry) {

        // return string
        String outStr = "";

        // for all string after add
        for (int i = 2; i < inArry.length; i++) {
            // add to return string
            outStr += inArry[i].trim() + " ";
        }

        // return string with leading and trailing white space removed
        String[] outStrArray = outStr.trim().split("<SEP>");

        // add to output array and trim each entry
        for (int i = 0; i < outStrArray.length; i++) {
            outStrArray[i] = outStrArray[i].trim();
            // System.out.println(outStrArray[i] + "|");
        }

        return outStrArray;
    }

}
