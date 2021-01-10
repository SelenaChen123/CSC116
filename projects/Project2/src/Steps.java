import java.util.*;
import java.awt.*;

/**
 * Draws 1-8 steps on both the top and bottom of a drawing panel
 *
 * @author Selena Chen
 */
public class Steps {
    /**
     * Declares constant variable for max number of steps
     */
    public static final int MAX_STEPS = 8;
    /**
     * Declares constant variable for max color value
     */
    public static final int MAX_COLOR_VALUE = 255;
    /**
     * Declares constant variable for canvas width
     */
    public static final int CANVAS_WIDTH = 740;
    /**
     * Declares constant variable for canvas height
     */
    public static final int CANVAS_HEIGHT = 420;
    /**
     * Declares constant variable for upper-lefthand x-coordinate
     */
    public static final int TOP_X = 5;
    /**
     * Declares constant variable for upper-lefthand y-coordinate
     */
    public static final int TOP_Y = 5;
    /**
     * Declares constant variable for lower-righthand x-coordinate
     */
    public static final int BOTTOM_X = 735;
    /**
     * Declares constant variable for lower-righthand x-coordinate
     */
    public static final int BOTTOM_Y = 415;
    /**
     * Declares constant variable for width of steps
     */
    public static final int WIDTH = 80;
    /**
     * Declares constant variable for height of steps
     */
    public static final int HEIGHT = 40;

    /**
     * Starts program
     *
     * @param args command line
     */
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        System.out.print("Number of steps (1-8): ");
        int numberOfSteps = console.nextInt();
        if(numberOfSteps < 1) {
            numberOfSteps = 1;
        }
        if(numberOfSteps > MAX_STEPS) {
            numberOfSteps = MAX_STEPS;
        }

        System.out.print("Red value (0-255): ");
        int red = console.nextInt();
        System.out.print("Green value (0-255): ");
        int green = console.nextInt();
        System.out.print("Blue value (0-255): ");
        int blue = console.nextInt();
        if(red < 0) {
            red = 0;
        }
        if(green < 0) {
            green = 0;
        }
        if(blue < 0) {
            blue = 0;
        }
        if(red > MAX_COLOR_VALUE) {
            red = MAX_COLOR_VALUE;
        }
        if(green > MAX_COLOR_VALUE) {
            green = MAX_COLOR_VALUE;
        }
        if(blue > MAX_COLOR_VALUE) {
            blue = MAX_COLOR_VALUE;
        }
        Color color = new Color(red, green, blue);
        Color inverseColor = new Color(MAX_COLOR_VALUE - red,
            MAX_COLOR_VALUE - green, MAX_COLOR_VALUE - blue);

        DrawingPanel panel = new DrawingPanel(CANVAS_WIDTH, CANVAS_HEIGHT);
        panel.setBackground(inverseColor);
        Graphics g = panel.getGraphics();

        drawTopSteps(g, color, numberOfSteps, TOP_X, TOP_Y, WIDTH, HEIGHT);
        drawBottomSteps(g, color, numberOfSteps, BOTTOM_X, BOTTOM_Y, WIDTH, HEIGHT);

        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }

    /**
     * Draws the given number of (upside down) steps with the given color
     *
     * @param g graphics
     * @param color given color
     * @param numberOfSteps given number of steps
     * @param x x-coordinate of upper-lefthand corner
     * @param y y-coordinate of upper-lefthand corner
     * @param width width of steps
     * @param height height of steps
     */
    public static void drawTopSteps(Graphics g, Color color, int numberOfSteps,
        int x, int y, int width, int height) {
        g.setColor(color);
        for(int i = numberOfSteps; i > 0; i--) {
            if(i == numberOfSteps) {
                g.fillRect(x, y, width * i, height);
            } else {
                g.fillRect(x, y + height * (numberOfSteps - i % numberOfSteps), width * i, height);
            }
        }
    }

    /**
     * Draws the given number of steps with the given color
     *
     * @param g graphics
     * @param color given color
     * @param numberOfSteps given number of steps
     * @param x x-coordinate of lower-righthand corner
     * @param y y-coordinate of lower-righthand corner
     * @param width width of steps
     * @param height height of steps
     */
    public static void drawBottomSteps(Graphics g, Color color, int numberOfSteps,
        int x, int y, int width, int height) {
        g.setColor(color);
        for(int i = numberOfSteps; i > 0; i--) {
            g.fillRect(x - width * i, y - height * (numberOfSteps + 1 - i), width * i, height);
        }

    }
}