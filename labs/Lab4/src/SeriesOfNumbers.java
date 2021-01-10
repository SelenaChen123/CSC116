/**
* This program displays 1 4 9 16 25 36 49 64 81 100.
* @author Ayushi Verma
* @author Selena Chen
*/
public class SeriesOfNumbers {
    /**
    * Starts program
    * @param args command line arguments
    */
    public static void main(String[] args) {
        printSeries();
    }

    /**
    * Prints numbers
    */
    public static void printSeries() {
        int number = 0;
        final int maxOdd = 19;
        for (int j = 1; j <= maxOdd; j += 2) {
            number += j;
            System.out.print(number + " ");
        }
    }
}
