import java.util.*;
import java.io.*;

/**
 * Program to get input from weather text file and process
 * 
 * @author Suzanne Balik
 * @author Jessica Young Schmidt
 * @author Selena Chen
 * @author Armaan Syed
 */
public class WeatherReporter {
    /**
     * Declares constant int for date substring
     */
    public static final int YEAR_MAX = 4;

    /**
     * Declares constant int for month substring
     */
    public static final int MONTH_MAX = 6;

    /**
     * Declares constant int for day substring
     */
    public static final int DAY_MAX = 8;

    /**
     * Starts program
     * 
     * @param args command arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Deals with all interactions with the user
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = getInput(console);
        try {
            processLine(fileScanner.nextLine());
        } catch (NoSuchElementException e) {
            System.out.println("Empty file. ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(processLine(line));
        }
    }

    /**
     * Processes a line of the text file (String) in order to print the correct
     * output to the console
     * 
     * @param line the line to be processed
     * @return processed line
     */
    public static String processLine(String line) {
        Scanner lineScan = new Scanner(line);
        String date = lineScan.next();
        String year = date.substring(0, YEAR_MAX);
        String month = date.substring(YEAR_MAX, MONTH_MAX);
        String day = date.substring(MONTH_MAX, DAY_MAX);
        lineScan.next();
        double high = lineScan.nextDouble();
        double low = lineScan.nextDouble();
        String weather = lineScan.next();
        String isRain = "";
        char rain = weather.charAt(1);
        if(rain == '1') {
            isRain = "yes";
        } else {
            isRain = "no";
        }
        String isSnow = "";
        char snow = weather.charAt(2);
        if(snow == '1') {
            isSnow = "yes";
        } else {
            isSnow = "no";
        }

        // NOTE: String.format can be used similar to System.out.printf
        return String.format("%2s/%2s/%4s Low:%6.1f High:%6.1f Rain:%4s Snow:%4s",
                month, day, year, low, high,
                isRain, isSnow);
    }

    /**
     * Prompt the user for a legal file name, create and return a Scanner tied to
     * the file
     * 
     * @param console console for user input
     * @return Scanner tied to the input file
     */
    public static Scanner getInput(Scanner console) {
        System.out.print("input file name? ");
        File file = new File(console.next());
        while (!file.exists()) {
            System.out.print("File doesn't exist. " + "input file name? ");
            file = new File(console.next());
        }
        Scanner fileScanner = null;
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
