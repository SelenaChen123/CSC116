/**
 * This program prints a pattern of vaguely lantern-like figures. The code uses
 * static methods for structure and to remove redundancy.
 * @author Selena Chen
 */
public class Lanterns {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        pyramid();
        System.out.println();

        lantern1();
        System.out.println();

        lantern2();
        System.out.println();
    }

    /**
     * Prints first lantern pattern
     */
    public static void lantern1() {
        pyramid();
        middle();
        thirteenStars();
        pyramid();
    }

    /**
     * Prints second lantern pattern
     */
    public static void lantern2() {
        pyramid();
        fiveStars();
        middle();
        middle();
        fiveStars();
        fiveStars();
    }

    /**
     * Prints pyramid pattern
     */
    public static void pyramid() {
        fiveStars();
        System.out.println("  *********");
        thirteenStars();
    }

    /**
     * Prints five star pattern
     */
    public static void fiveStars() {
        System.out.println("    *****");
    }

    /**
     * Prints thirteen star pattern
     */
    public static void thirteenStars() {
        System.out.println("*************");
    }

    /**
     * Prints lantern middle pattern
     */
    public static void middle() {
        System.out.println("* | | | | | *");
    }
}