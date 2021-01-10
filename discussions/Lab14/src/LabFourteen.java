import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab 14 code as class
 *
 * @author CSC116-002-f18
 */
public class LabFourteen {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Interface with the user
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        File file = getInputFilename(console);
        Scanner fileScanner = getInputScanner(file);

        System.out.println("\n\n****Reverse line order:");
        System.out.println(reverseLineOrder(fileScanner));

        fileScanner = getInputScanner(file);
        System.out.println("\n\n****Reverse each line:");
        System.out.println(reverseLine(fileScanner));
    }

    /**
     * Reverses word order in line
     * 
     * @param fileScanner scanner for file
     * @return String with words reversed on each line
     */
    public static String reverseLine(Scanner fileScanner) {
        String ret = "";
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            Scanner lineScan = new Scanner(line);
            String reverseLine = "\n";
            while(lineScan.hasNext()){
                String token = lineScan.next();
                reverseLine = token + " " + reverseLine;
            }
            ret += reverseLine;
        }
        return ret;    
    }

    /**
     * Reverses order of lines
     * 
     * @param fileScanner scanner for file
     * @return String with lines reversed
     */
    public static String reverseLineOrder(Scanner fileScanner) {
        String ret = "";
        while(fileScanner.hasNextLine()){
            ret = fileScanner.nextLine() + "\n" + ret;
        }
        return ret;
    }

    /**
     * Reads filename from user until the file exists, then return a file scanner
     * 
     * @param console Scanner that reads from the console
     * 
     * @return a scanner to read input from the file
     */
    public static Scanner getInputScanner(Scanner console) {
        System.out.print("Enter a file name to process: ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "Enter a file name to process: ");
            file = new File(console.next());
        }
        Scanner fileScanner = null;// null signifies NO object reference
                                   // while (result == null) {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return fileScanner;
    }

    /**
     * Reads filename from user until the file exists, then return a file
     * 
     * @param console Scanner that reads from the console
     * 
     * @return a file to read input
     */
    public static File getInputFilename(Scanner console) {
        System.out.print("Enter a file name to process: ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "Enter a file name to process: ");
            file = new File(console.next());
        }
        return file;
    }

    /**
     * Return a file scanner
     * 
     * @param file file to create scanner for
     * 
     * @return a scanner to read input from the file
     */
    public static Scanner getInputScanner(File file) {
        Scanner fileScanner = null;// null signifies NO object reference
                                   // while (result == null) {
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return fileScanner;
    }

}
