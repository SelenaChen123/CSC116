/**
* Methods in class calculate area for various shapes
* 
* @author Selena Chen
* @author Ayushi Verma
*/
public class MyAreaCalculations {

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println(triangleArea(1, 1, 1));// EXPECTED OUTPUT: 0.4330127018922193
        System.out.println(cylinderSurfaceArea(1, 1)); // EXPECTED OUTPUT: 12.566370614359172
    }

    /**
     * Returns the area of a triangle with given side lengths
     * 
     * @param sideA first side of triangle
     * @param sideB second side of triangle
     * @param sideC third side of triangle
     * @return area area of triangle
     */
    public static double triangleArea(double sideA, double sideB, double sideC) {
        double s = (sideA + sideB + sideC) / 2;
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return area;
    }

    /**
     * Returns the surface area of a cylinder with the given radius and height
     * 
     * @param radius radius of cylinder
     * @param height height of cylinder
     * @return surfaceArea surface area of cylinder
     */
    public static double cylinderSurfaceArea(double radius, double height) {
        double surfaceArea = (2 * Math.PI * Math.pow(radius, 2)) + (2 * Math.PI * radius * height);
        return surfaceArea;
    }
}
