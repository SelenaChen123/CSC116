import java.util.Scanner;

/**
 * Finds the smallest divisor of an integer
 * 
 * @author Jessica Young Schmidt
 * @author CSC116-002 (Fall 2018)
 */
public class SmallestDivisor {
    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Write method to complete the given task
        // Add single input from the perfect user
        // Add repeated input from user until sentinel is reached
        // Add check for expected range
        // Add check for correct type
        Scanner console = new Scanner(System.in);
        System.out.print("Enter int greater than 1: ");
        while(!console.hasNextInt()){
            console.next();
            System.out.print("REMINDER: Enter int greater than 1: ");
        }
        int val = console.nextInt();
        if(val > 1){
            System.out.println("Smallest divisor: " + smallestDivisor(val));
        } else {
            System.out.println("Not in range.");
        }
    }

    /**
     * Returns smallest divisor of number
     * 
     * @param number value to find smallest divisor of
     * @return smallest divisor of number
     */
    public static int smallestDivisor(int number) {
        if (number <= 1){
            throw new IllegalArgumentException("Invalid integer: " + number);
        }
        // pseudocode
        // start divisor at 2.
        int divisor = 2;
        // while (current divisor doesn’t work){
        while(number % divisor != 0){
        // increase divisor.
            divisor++;
        // }
        }
        
        return divisor;
    }






}
