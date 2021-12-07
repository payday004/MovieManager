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

    public CommandReader(int memSize, int hashSize, File commandFile)
        throws FileNotFoundException {
        
        Scanner scan = new Scanner(commandFile);
        
        //database object
        DataBase dB = new DataBase(hashSize, memSize); 
        
        //for each line in input file 
        while (scan.hasNextLine()) {
            
            //split strings
            String command = scan.nextLine();
            String[] word = command.trim().split("\\s+", -2);

            
            // update lines
            if (word[0].contains("update")) {
                
                // update add 
                if (word[1].contains("add")) {
                    //System.out.println(command);
                }
                
                // update delete
                else {
                    //System.out.println(command);
                }
            }
            
            
            
            // add line
            else if (word[0].contains("add")) {
                
                System.out.println(command);
                
                System.out.println(getName(word));
                
                //add record into database
                dB.add(new Record(getName(word)));    
            }
            
            
            
            //delete line
            else if (word[0].contains("delete")) {
                //System.out.println(command);
                
                System.out.println(command);
                
                System.out.println(getName(word));
                
                //delete record from database
                dB.delete(new Record(getName(word)));
            }
            
            
            
            // print lines
            else if (word[0].contains("print")) { 
                
                // print hashtable
                if (word[1].contains("hashtable")) {
                    //echo command
                    System.out.println(command);
                    
                    //print HashTable
                    dB.printHash();
                }
                
                //print memory block
                else {
                    //System.out.println(command);
                }
            }
                        
            System.out.println("\n");
        }
        
        // close scanner 
        scan.close();
    }
    
    
    
    /**
     * helper method to get Canonical Name
     * @param inArry
     * @return
     */
    private String getName(String[] inArry) {
        
        //return string 
        String outStr = "";
        
        //for all string after add
        for(int i = 1; i < inArry.length; i++) {
            //add to return string
            outStr += inArry[i].trim() + " "; 
        }
        
        //return string with leading and trailing white space removed
        return outStr.trim(); 
    }
    
}
