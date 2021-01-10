/**
 * Simple test of FindPerfectNumbers
 * 
 * @author Jessica Young Schmidt
 */
public class FindPerfectNumbersTest {
    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Is 30 a perfect number? Expected: false, Actual: "
                + FindPerfectNumbers.isPerfectNumber(30));
        System.out.println("\nIs 496 a perfect number? Expected: true, Actual: "
                + FindPerfectNumbers.isPerfectNumber(496));
        String pnThirty = FindPerfectNumbers.perfectNumbers(30);
        System.out.println("\nPerfect numbers up to 30: " + pnThirty);
        if (pnThirty.trim().equals("6 28")) {
            System.out.println("String matches expected");
        } else {

            System.out.println("String does NOT match expected");
        }
    }

}
