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

    
    public CommandReader(File commandFile) throws FileNotFoundException {
        Scanner scan = new Scanner(commandFile);
        while (scan.hasNextLine()) {
            String command = scan.nextLine();
            String[] word = command.trim().split("\\s+", -2);
        
            if (word[0].contains("update")) {
                if (word[1].contains("add")) {
                    System.out.println("update add");
                }
                else { //update delete block
                    System.out.println("update delete");
                }
            }
            else if (word[0].contains("add")) {
                System.out.println("add");
            }
            else if (word[0].contains("delete")) {
                System.out.println("delete");
            }
            else if (word[0].contains("print")) {
                if (word[1].contains("hashtable")) {
                    System.out.println("print hashtable");
                }
                else { //print memory block of code
                    System.out.println("print memory");
                }
            }
            
            
        }
    }
}
