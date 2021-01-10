import java.util.*;
import java.io.*;

/**
 * Program reads in a file and find the max, min, sum, count, and average of all
 * integers in the file
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 * @author Dr. Jessica Young Schmidt
 * @author Selena Chen
 * @author Armaan Syed
 */
public class ProcessFile {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     * @throws FileNotFoundException if file cannot be found
     */
    public static void main(String[] args) throws FileNotFoundException {
        userInterface();
    }

    /**
     * Interface with the user
     * 
     * @throws FileNotFoundException if file cannot be found
     */
    public static void userInterface() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInputScanner(console);
        System.out.println(processFile(fileScanner));
    }

    /**
     * Processing the file
     * 
     * @param fileScanner Scanner for file
     * @return String that contains the stats
     */
    public static String processFile(Scanner fileScanner) {
        int max = 0, min = 0, sum = 0, count = 0;
        double average = 0.0;

        while(fileScanner.hasNext()) {
            while(!fileScanner.hasNextInt()) {
                fileScanner.next();
                if(!fileScanner.hasNext()) {
                    return "No integers in file.";
                }
            }
            while(fileScanner.hasNextInt()) {
                count++;
                int integer = fileScanner.nextInt();
                if(count > 1) {
                    sum += integer;
                    if(integer < min) {
                        min = integer;
                    }
                    if(integer > max) {
                        max = integer;
                    }
                } else {
                    sum = integer;
                    min = integer;
                    max = integer;
                }
            }
            average = sum / count;
        }

        // Only print if count is positive
        if (count > 0) {
            return "Maximum = " + max + "\nMinimum = " + min + "\nSum = " + sum + "\nCount = "
                    + count + "\nAverage = " + average;
        } else {
            return "No integers in file.";
        }
    }

    /**
     * Reads filename from user until the file exists, then return a file scanner
     * 
     * @param console Scanner that reads from the console
     * @return a scanner to read input from the file
     * @throws FileNotFoundException if file cannot be found
     */
    public static Scanner getInputScanner(Scanner console) throws FileNotFoundException {
        System.out.print("Enter a file name to process: ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.print("File doesn't exist. Enter a file name to process: ");
            file = new File(console.next());
        }

        Scanner fileScanner = new Scanner(file);
        return fileScanner;
    }
}
