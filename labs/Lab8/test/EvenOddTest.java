/**
 * Tests methods that calculate min, max, and average of three values
 * 
 * @author Jessica Young Schmidt
 */
public class EvenOddTest {

    /** Format used for printf */
    public static final String FORMAT = "%-35s%10s%10s\n";

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Method Call                          Expected    Actual");
        System.out.println("-------------------------------------------------------");

        System.out.printf(FORMAT, "evenOdd(0)", "Even", EvenOdd.evenOdd(0));
        System.out.printf(FORMAT, "evenOdd(10)", "Even", EvenOdd.evenOdd(10));
        System.out.printf(FORMAT, "evenOdd(22)", "Even", EvenOdd.evenOdd(22));
        System.out.printf(FORMAT, "evenOdd(-14)", "Even", EvenOdd.evenOdd(-14));
        System.out.printf(FORMAT, "evenOdd(1)", "Odd", EvenOdd.evenOdd(1));
        System.out.printf(FORMAT, "evenOdd(99)", "Odd", EvenOdd.evenOdd(99));
        System.out.printf(FORMAT, "evenOdd(-3)", "Odd", EvenOdd.evenOdd(-3));
        System.out.printf(FORMAT, "evenOdd(7)", "Odd", EvenOdd.evenOdd(7));

    }

}
