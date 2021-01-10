/**
 * Tests methods that calculate min, max, and average of three values
 * 
 * @author Jessica Young Schmidt
 */
public class TriangleTest {

    /** Format used for printf */
    public static final String FORMAT = "%-35s%-20s%-20s\n";

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Method Call                        Expected            Actual");
        System.out.println(
                "---------------------------------------------------------------------------");

        System.out.printf(FORMAT, "isValidTriangle(0,5,6)", "false",
                Triangle.isValidTriangle(0, 5, 6));
        System.out.printf(FORMAT, "isValidTriangle(1,4,6)", "false",
                Triangle.isValidTriangle(1, 4, 6));
        System.out.printf(FORMAT, "isValidTriangle(3,4,6)", "true",
                Triangle.isValidTriangle(3, 4, 6));
        System.out.printf(FORMAT, "getTriangleType(0,5,6)", "Not Valid Triangle",
                Triangle.getTriangleType(0, 5, 6));
        System.out.printf(FORMAT, "getTriangleType(1,4,6)", "Not Valid Triangle",
                Triangle.getTriangleType(1, 4, 6));
        System.out.printf(FORMAT, "getTriangleType(3,4,6)", "Scalene",
                Triangle.getTriangleType(3, 4, 6));
        System.out.printf(FORMAT, "getTriangleType(4,4,6)", "Isosceles",
                Triangle.getTriangleType(4, 4, 6));
        System.out.printf(FORMAT, "getTriangleType(6,6,6)", "Equilateral",
                Triangle.getTriangleType(6, 6, 6));

    }

}
