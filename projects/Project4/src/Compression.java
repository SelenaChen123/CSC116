import java.util.*;
import java.io.*;

/**
 *
 * Compresses text by replacing frequently-occurring English character sequences
 * with special characters
 *
 * @author Selena Chen
 *
 */
public class Compression {
    /**
     *
     * Starts the program
     *
     * @param args command line arguments
     *
     */
    public static void main(String[] args) {
        System.out.println("Text Compression Program");
        System.out.println();
        System.out.println("Text compression allows us to store files using a smaller amount of");
        System.out.println("disk space and to transfer them more quickly. This program compresses");
        System.out.println("and decompresses text files using a very simple form of text");
        System.out.println("compression. The compression will be done by replacing seven of the");
        System.out.println("two- and three-character sequences that frequently occur in the");
        System.out.println("English language with special characters. Decompressing a compressed");
        System.out.println("file will result in the original file.");
        System.out.println();
        
        Scanner console = new Scanner(System.in);
        
        String action = "";
        do {
            System.out.print("Enter C-ompress, D-ecompress, or Q-uit: ");
            action = console.next();
            action = action.toUpperCase();
            while(!action.equals("C") && !action.equals("D") && !action.equals("Q")) {
                System.out.println("Invalid Action");
                System.out.print("Enter C-ompress, D-ecompress, or Q-uit: ");
                action = console.next();
                action = action.toUpperCase();
            }

            if(action.equals("Q")) {
                System.exit(1);
            }

            boolean compress = false;
            if(action.equals("C")) {
                compress = true;
            }

            processFile(compress, getInputScanner(console), getOutputPrintStream(console));
        } while (!action.equals("Q"));
    }

    /**
     *
     * Repeatedly prompts the user for the name of an input file until the user enters
     * the name of an existing file; then creates and returns a Scanner for the input file.
     *
     * @param console Scanner that reads from the console
     * @return fileScanner scans the user-inputted file
     *
     */
    public static Scanner getInputScanner(Scanner console){
        System.out.print("Enter input file: ");
        String filename = console.next();
        File file = new File(filename);
        while(!file.exists()) {
            System.out.println(filename + " (No such file or directory)");
            System.out.print("Enter input file: ");
            filename = console.next();
            file = new File(filename);
        }
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    /**
     *
     * Prompts the user for the name of an output file.
     * If the file does not exist, creates and returns a PrintStream for the output file.
     * If the file does exist, prints an error message and returns null OR
     * does one of the Extra Credit options described below.
     *
     * @param console Scanner that reads from the console
     * @return null
     *
     */
    public static PrintStream getOutputPrintStream(Scanner console){
        PrintStream output = null;
        String filename = "";
        File file = null;
        String answer = "";
        do {
            try {
                System.out.print("Enter output file: ");
                filename = console.next();
                file = new File(filename);
                if(file.exists()) {
                    System.out.println("File exists");
                    System.out.print("Overwrite file? (Y/N) ");
                    answer = console.next();
                    answer = answer.toUpperCase();
                    if(answer.equals("Y")) {
                        output = new PrintStream(new File(filename));
                    } else {
                        System.out.print("Enter output file: ");
                        filename = console.next();
                        file = new File(filename);
                        while(file.exists() && output == null) {
                            System.out.println("File exists");
                            System.out.print("Overwrite file? (Y/N) ");
                            answer = console.next();
                            answer = answer.toUpperCase();
                            if(answer.equals("Y")) {
                                output = new PrintStream(new File(filename));
                            } else {
                                System.out.print("Enter output file: ");
                                filename = console.next();
                                file = new File(filename);
                            }
                        }
                    }
                }
                output = new PrintStream(new File(filename));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (output == null);
        return output;
    }

    /**
     *
     * If compress is true, compresses text in input and outputs compressed text
     * If compress is false, decompresses text in input and outputs decompressed text
     *
     * @param compress whether or not the method should compress
     * @param input file to be processed
     * @param output file to be printed to
     *
     */
    public static void processFile (boolean compress, Scanner input, PrintStream output){
        if(compress) {
            while(input.hasNextLine()) {
                output.println(compressLine(input.nextLine()));
            }
        } else {
            while(input.hasNextLine()) {
                output.println(decompressLine(input.nextLine()));
            }
        }
    }

    /**
     *
     * Returns string containing compressed line
     *
     * @param line line to be compressed
     * @return compressedLine compressed line
     *
     */
    public static String compressLine(String line){
        String compressedLine = "";
        Scanner lineScanner = new Scanner(line);
        while(lineScanner.hasNext()) {
            String word = lineScanner.next();
            String compressedWord = compressWord(word);
            compressedLine += compressedWord;
            if(lineScanner.hasNext()) {
                compressedLine += " ";
            }
        }
        return compressedLine;
    }

    /**
     *
     * Returns string containing compressed word (token)
     *
     * @param word word to be compressed
     * @return compressedWord compressed word
     *
     */
    public static String compressWord(String word) {
        String compressedWord = "";
        int index = word.indexOf("the");
        if(index > -1) {
            compressedWord = word.substring(0, index) + "&" + word.substring(index + 3);
        } else {
            compressedWord = word;
        }
        index = compressedWord.indexOf("an");
        if(index > -1) {
            compressedWord = compressedWord.substring(0, index) + "~"
                                + compressedWord.substring(index + 2);
        }
        index = compressedWord.indexOf("ion");
        if(index > -1) {
            compressedWord = compressedWord.substring(0, index) + "#"
                                + compressedWord.substring(index + 3);
        }
        index = compressedWord.indexOf("ing");
        if(index > -1) {
            compressedWord = compressedWord.substring(0, index) + "@"
                                + compressedWord.substring(index + 3);
        }
        index = compressedWord.indexOf("tis");
        if(index > -1) {
            compressedWord = compressedWord.substring(0, index) + "%"
                                + compressedWord.substring(index + 3);
        }
        index = compressedWord.indexOf("men");
        if(index > -1) {
            compressedWord = compressedWord.substring(0, index) + "+"
                                + compressedWord.substring(index + 3);
        }
        index = compressedWord.indexOf("re");
        if(index > -1) {
            compressedWord = compressedWord.substring(0, index) + "$"
                                + compressedWord.substring(index + 2);
        }
        return compressedWord;
    }

    /**
     *
     * Returns string containing decompressed line
     *
     * @param line line to be decompressed
     * @return string decompressed line
     *
     */
    public static String decompressLine(String line){
        String decompressedLine = "";
        Scanner lineScanner = new Scanner(line);
        while(lineScanner.hasNext()) {
            String word = lineScanner.next();
            String decompressedWord = decompressWord(word);
            decompressedLine += decompressedWord;
            if(lineScanner.hasNext()) {
                decompressedLine += " ";
            }
        }
        return decompressedLine;
    }

    /**
     *
     * Returns string containing decompressed word (token)
     *
     * @param word word to be decompressed
     * @return decompressedWord decompressed word
     *
     */
    public static String decompressWord(String word) {
        String decompressedWord = "";
        int index = word.indexOf("&");
        if(index > -1) {
            decompressedWord = word.substring(0, index) + "the" + word.substring(index + 1);
        } else {
            decompressedWord = word;
        }
        index = decompressedWord.indexOf("~");
        if(index > -1) {
            decompressedWord = decompressedWord.substring(0, index) + "an"
                                + decompressedWord.substring(index + 1);
        }
        index = decompressedWord.indexOf("#");
        if(index > -1) {
            decompressedWord = decompressedWord.substring(0, index) + "ion"
                                + decompressedWord.substring(index + 1);
        }
        index = decompressedWord.indexOf("@");
        if(index > -1) {
            decompressedWord = decompressedWord.substring(0, index) + "ing"
                                + decompressedWord.substring(index + 1);
        }
        index = decompressedWord.indexOf("%");
        if(index > -1) {
            decompressedWord = decompressedWord.substring(0, index) + "tis"
                                + decompressedWord.substring(index + 1);
        }
        index = decompressedWord.indexOf("+");
        if(index > -1) {
            decompressedWord = decompressedWord.substring(0, index) + "men"
                                + decompressedWord.substring(index + 1);
        }
        index = decompressedWord.indexOf("$");
        if(index > -1) {
            decompressedWord = decompressedWord.substring(0, index) + "re"
                                + decompressedWord.substring(index + 1);
        }
        return decompressedWord;
    }
}
