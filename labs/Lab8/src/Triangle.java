import java.util.Scanner;
/** 
 * Determines whether a triangle is valid and the type of triangle
 * 
 * @author Ayushi Verma
 * @author Selena Chen
 */
public class Triangle {
    /**
    * Starts program
    * @param args command line arguments
    */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter 3 integers for the 3 sides of a triangle: ");
        int side1 = console.nextInt();
        int side2 = console.nextInt();
        int side3 = console.nextInt();
        isValidTriangle(side1, side2, side3);
        getTriangleType(side1, side2, side3);
    }

    /**
    * Determines whether or not triangle is valid
    * @param side1 first side of triangle
    * @param side2 second side of triangle
    * @param side3 third side of triangle
    * @return true or false
    */
    public static boolean isValidTriangle(int side1, int side2, int side3) {
        if((side1 > (side2 + side3)) || (side2 > (side1 + side3)) || (side3 > (side1 + side2))) {
            return false;
        }

        if(side1 < 0 || side2 < 0 || side3 < 0) {
            return false;
        }
        
        return true;
    }

    /**
    * Determines what type of triangle it is
    * @param side1 first side of triangle
    * @param side2 second side of triangle
    * @param side3 third side of triangle
    * @return "Equilateral," "Isosceles," "Scalene," or "Not Valid Triangle"
    */
    public static String getTriangleType(int side1, int side2, int side3) {
        if(isValidTriangle(side1, side2, side3) == false) {
            return "Not Valid Triangle";
        } else if(side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else if(side1 == side2 || side1 == side3 || side2 == side3) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}