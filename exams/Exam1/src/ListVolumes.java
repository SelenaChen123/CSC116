import java.util.Scanner;
/**
 * Calculates the volumes of various pyramids
 * 
 * @author Jessica Young Schmidt
 * @author Selena Chen
 */
public class ListVolumes { 

    /**
     * Main method that starts program and handles user I/O
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("Enter the length minimum: ");
        int lengthMin = console.nextInt();
        System.out.print("Enter the width minimum: ");
        int widthMin = console.nextInt();
        System.out.print("Enter the height minimum: ");
        int heightMin = console.nextInt();
        System.out.print("Enter the length maximum: ");
        int lengthMax = console.nextInt();
        System.out.print("Enter the width maximum: ");
        int widthMax = console.nextInt();
        System.out.print("Enter the height maximum: ");
        int heightMax = console.nextInt();
        System.out.println();
        String output = getVolumes(lengthMin, lengthMax, heightMin, heightMax, widthMin, widthMax);
        System.out.println(output);
        console.close();
    }

    /**
     * Generates volumes for various pyramids
     * 
     * @param lMin minimum length (integer)
     * @param lMax maximum length (integer)
     * @param wMin minimum width (integer)
     * @param wMax maximum length (integer)
     * @param hMin minimum height (integer)
     * @param hMax maximum height (integer)
     * @return String of all of the volumes
     */
    public static String getVolumes(int lMin, int lMax, int hMin, int hMax, int wMin, int wMax) {
        String output = "";
        for (int l = lMin; l <= lMax; l++) {
            for (int w = wMin; w <= wMax; w++) {
                for (int h = hMin; h <= hMax; h++) {
                    output += ("getVolume(" + l + "," + h + "," + w + "): " + getVolume(l, h, w)
                            + "\n"); 
                }
            }
        }
        return output;
    }

    /**
     * Calculates volume of the pyramid with the given measurements
     * 
     * @param length length of the pyramid (double)
     * @param width width of the pyramid (double)
     * @param height height of the pyramid (double)
     * @return volume of the pyramid with the given measurements (double)
     */
    public static double getVolume(double length, double height, double width) {
        return length * width * height / 3;
    }
}
