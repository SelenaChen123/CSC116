/**
 * Tests methods that prints series of numbers
 * 
 * @author Jessica Young Schmidt
 */
public class SeriesOfNumbersTest {
    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Expected:   1 4 9 16 25 36 49 64 81 100");

        System.out.print("Actual:     ");
        SeriesOfNumbers.printSeries();
        
        System.out.println("End of Test.");

    }

}
