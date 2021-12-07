import java.io.File;
import java.io.FileNotFoundException;

/**
 * The class containing the main method and takes in the parameters
 * for memory size, hash table size, and the command file to read.
 *
 * @author Justin Shelton and Peyton Dexter
 * @version 12.1.2021
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class MemMan {
    /**
     * @param args
     *            Command line parameters
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException {

        //printing arguments
        //System.out.println(args[0]);
        //System.out.println(args[1]);
        //System.out.println(args[2]);
        
        // reading command line argument 
        int memSize = Integer.parseInt(args[0]);
        int hashSize = Integer.parseInt(args[1]);
        String str = args[2]; 
        
        //open file
        File file = new File(str);
        
        //run CommandReader driver
        new CommandReader(memSize, hashSize, file);

    }

}
