import java.util.Scanner;

/**
* Prompts user for full name, then prints the reverse
* 
* @author Selena Chen
*/
public class ReverseNames {
    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Note that if user doesn't follow instructions, we cannot guarantee
        // the correct output.

        Scanner in = new Scanner(System.in);
        System.out.println("Your name in reverse order is: " + getReverse(in));
    }

    // Method should prompt user for name then return string with the name reversed
    /**
    * Prompts user for full name, then returns the reverse
    * 
    * @param console user input
    * @return reverse reverse of user-inputted full name
    */
    public static String getReverse(Scanner console) {
        System.out.print("Please enter your full name: ");
        console = new Scanner(System.in);
        String first = console.next();
        String last = console.next();
        String reverse = last + ", " + first;
        return reverse;
    }
}
