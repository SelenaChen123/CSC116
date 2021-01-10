import java.io.*;
import java.util.*;
/**
 * This program collapses spaces between tokens and outputs it to a specific file 
 *
 * @author Selena Chen
 * @author Armaan Syed
 */ 
public class Collapse {

    /**
     * Starts the program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        Scanner in = null;
        String file = "";
        while (in == null){
            System.out.print("input file name? ");
            file = console.nextLine();
            try {
                in = new Scanner (new File(file));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }


        PrintStream out = null;
        String filename = "";
        while (out == null){
            System.out.print("output file name? ");
            filename = console.nextLine();
            try {
                out = new PrintStream(new File(filename));
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
            }
        }
        collapseSpaces(in, out);
    }

    /**
     * This method collapses the spaces 
     * 
     * @param in Reads input file
     * @param out Prints output to output file 
     */
    public static void collapseSpaces(Scanner in, PrintStream out){
        while (in.hasNextLine()){
            Scanner lineScanner = new Scanner(in.nextLine());
            while (lineScanner.hasNext()){
                out.print(lineScanner.next());
                if (lineScanner.hasNext()){
                    out.print(" ");
                }
            }
            if (in.hasNextLine()){
                if (in.hasNext()){
                    out.println();
                }            
            }
        }
    }
}
