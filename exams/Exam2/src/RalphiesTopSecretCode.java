import java.io.*;
import java.util.*;

/**
 * Translates a file containing English to "Ralphie's Top Secret Code" and
 * output the results in another file
 * 
 * @author Selena Chen
 */
public class RalphiesTopSecretCode {

    /**
     * Starts the program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * User interface that gets output and input file names from the user. A Scanner
     * is created for the input file and a PrintStream is created for the output
     * file. If the objects are created successfully, then the input files is
     * processed and results are printed to the output file via the processFile
     * method
     */
    public static void userInterface() {
        printInstructions();
        Scanner console = new Scanner(System.in);
        System.out.print("Input File Name? ");
        String inputFile = console.nextLine();
        System.out.print("Output File Name? ");
        String outputFile = console.nextLine();

        Scanner inputFileScanner = getScanner(inputFile);
        PrintStream outputFilePrintStream = getPrintStream(outputFile);
        if (inputFileScanner != null && outputFilePrintStream != null) {
            processFile(outputFilePrintStream, inputFileScanner);
        }

    }

    /**
     * Returns a Scanner for the String representing a possible file name or null if
     * the file does not exist in the file system
     * 
     * @param inputFileName String containing the user's input of a fileName
     * @return a Scanner or null if the file does not exist
     */
    public static Scanner getScanner(String inputFileName) {
        Scanner input = null;
        try {
            File filename = new File(inputFileName);
            input = new Scanner(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
        return input;
    }

    /**
     * Returns a PrintStream or null if the file cannot be created in the file
     * system (which could be due to no space or lack of permissions).
     * 
     * @param outputFileName String containing the user's output file name
     * @return a PrintStream or null if file cannot be written
     */
    public static PrintStream getPrintStream(String outputFileName) {
        PrintStream output = null;
        try {
            File filename = new File(outputFileName);
            output = new PrintStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be written!");
        }
        return output;
    }

    /**
     * Processes the file using the given Scanner and PrintStream. A
     * precondition of the method is that the Scanner and PrintStream cannot be
     * null.
     * 
     * @param output a PrintStream for the output file
     * @param input a Scanner for the input file
     */
    public static void processFile(PrintStream output, Scanner input) {
        while (input.hasNextLine()) {
      
            String line = input.nextLine();
            String rsLine = processLine(line);
            output.println(rsLine);
        }
    }

    /**
     * Processes each line of the input file and changes each English token to
     * "Ralphie's Top Secret Code"
     * 
     * @param line a line of input
     * @return the line in "Ralphie's Top Secret Code"
     */
    public static String processLine(String line) {
        Scanner lineScan = new Scanner(line);
        String rsLine = "";
        while (lineScan.hasNext()) {
            rsLine += translate(lineScan.next()) + " ";
        }
        return rsLine;
    }

    /**
     * Translates an English token into "Ralphie's Top Secret Code". PRE: token has
     * length >= 1
     *
     * @param token token to translate to "Ralphie's Top Secret Code"
     * @return the "Ralphie's Top Secret Code" token in lowercase letters
     * @throws IllegalArgumentException if token is empty string
     */
    public static String translate(String token) {
        if (token.length() < 1) {
            throw new IllegalArgumentException("Empty string");
        }
        token = token.trim();
        String newToken = "";
        token = token.toLowerCase();
        char lastChar = token.charAt(token.length() - 1);
        if (Character.isLetter(lastChar)) {
            if (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o'
                    || lastChar == 'u') {
                newToken = (char) (lastChar + 1) + reverse(token);
            } else if (lastChar == 'w' || lastChar == 'l' || lastChar == 'f') {
                String firstHalf = token.substring(0, token.length() / 2);
                String lastHalf = token.substring(token.length() / 2);
                newToken = (char) (lastChar - 1) + firstHalf + reverse(lastHalf);
            } else {
                newToken = reverse(token);
            }
        } else {
            newToken = token; // do NOT translate if doesn't end with a letter
        }
        return newToken;
    }

    /**
     * reverses the order of the string str
     * 
     * @param str string that will be reversed
     * @return reversed str
     */
    public static String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += (str.charAt(i));
        }
        return reversed;
    }

    /**
     * Prints the instructions of how to use the program
     */
    public static void printInstructions() {
        System.out.println("Welcome to \"Ralphie's Top Secret Code\" Translator");
        System.out.println("You will be prompted for an output file name");
        System.out.println("that will store the results of translating");
        System.out.println("English into \"Ralphie's Top Secret Code\"");
        System.out.println();
        System.out.println("The English to translate will be read in from");
        System.out.println("a user provided file");
        System.out.println();
    }

}
