/**
* Our Math class provides methods that return the min, max, and average of three values
* @author Selena Chen
* @author Ayushi Verma
*/
public class MyMath {
    /**
     * Starts the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println(min(0, 1, 10)); // EXPECTED OUTPUT: 0.0
        System.out.println(max(0, 1, 10)); // EXPECTED OUTPUT: 10.0
        System.out.println(average(0, 1, 10)); // EXPECTED OUTPUT: 3.6666666666666665
    }

    /**
     * Returns the smallest parameter
     * 
     * @param a first double in comparison
     * @param b second double in comparison
     * @param c third double in comparison
     * @return min minimum of a, b, c
     */
    public static double min(double a, double b, double c) {
        double firstMin = Math.min(a, b);
        double min = Math.min(firstMin, c);
        return min;
    }

    /**
     * Returns the largest parameter
     * 
     * @param a first double in comparison
     * @param b second double in comparison
     * @param c third double in comparison
     * @return max maximum of a, b, c
     */
    public static double max(double a, double b, double c) {
        double firstMax = Math.max(a, b);
        double max = Math.max(firstMax, c);
        return max;
    }

    /**
     * Returns the average of the three parameters
     * 
     * @param a first double in average
     * @param b second double in average
     * @param c third double in average
     * @return average average of a, b, c
     */
    public static double average(double a, double b, double c) {
        double average = (a + b + c) / 3;
        return average;
    }
}
