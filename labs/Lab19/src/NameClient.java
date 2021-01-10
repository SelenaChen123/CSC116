import java.util.*;

/**
 * Creates an array of five Names, reads in names from the console, and
 * prints the array name by name (in normal order) such that each full name is on its own line.
 *
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class NameClient {
    /** Constant integer for the number of names */
    private static final int NUMBER_OF_NAMES = 5;

    /**
     * Starts the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Name[] names = new Name[NUMBER_OF_NAMES];
        for(int i = 0; i < names.length; i++) {
            Name n = new Name();
            System.out.print("First name: ");
            n.setFirstName(console.next());
            System.out.print("Middle initial: ");
            n.setMiddle(console.next().charAt(0));
            System.out.print("Last name: ");
            n.setLastName(console.next());
            names[i] = n;
            System.out.println(n.toString());
        }
    }
}
