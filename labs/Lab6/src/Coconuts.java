import java.util.Scanner;

/**
 * Calculates and displays numbers of coconuts in the "Coconuts" story
 *
 * @author Selena Chen
 */
public class Coconuts {
    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a non-negative integer a: ");
        int a = console.nextInt();
        printResults(a);
    }

    /**
     * Prints the results of the "Coconuts" story given a user-inputted integer
     * 
     * @param a non-negative integer used to calculate initial number of coconuts
     */
    public static void printResults(int a) {
        final int INITIAL_NUM = 12495;
        final int COEFFICIENT = 15625;
        int initial = INITIAL_NUM + (COEFFICIENT * a);
        System.out.println("The initial number of coconuts is " + initial + ".");
        int remaining = initial;
        final int MAX_SAILORS = 5;
        final int DIVISOR = 5;
        final int MULTIPLIER = 8;
        for(int i = 1; i <= MAX_SAILORS; i++) {
            int sailor = remaining / DIVISOR;
            System.out.println("Sailor " + i + ": " + sailor + " coconuts; Monkey: 1 coconut.");
            remaining = (remaining * MULTIPLIER) / 10 - 1;
        }
        int sailor = remaining / DIVISOR;
        System.out.print(remaining + " coconuts remain, ");
        System.out.print("each sailor gets " + sailor + " and 1 for the monkey.");
        System.out.println();
    }
}