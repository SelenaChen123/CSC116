import java.awt.*;
import java.util.*;

/**
 * Animates pacman moving across screen
 *
 * @author Selena Chen
 */
public class Animation {
    /**
     * Declares constant int for canvas width
     */
    public static final int WIDTH = 500;
    /**
     * Declares constant int for canvas height
     */
    public static final int HEIGHT = 400;
    /**
     * Declares constant int for sleep time
     */
    public static final int SLEEP_TIME = 200;
    /**
     * Declares constant int for x-coordinate of initial position
     */
    public static final int INITIAL_X = 10;
    /**
     * Declares constant int for y-coordinate of initial position
     */
    public static final int INITIAL_Y = 200;
    /**
     * Declares constant int for the number of updates
     */
    public static final int NUMBER_OF_UPDATES = 80;
    /**
     * Declares constant int for position increment
     */
    public static final int DX = 5;
    
    /**
     * Starts the program
     *
     * @param args command line statements
     */
    public static void main (String[] args) {
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g);
            drawFigure(g, x + DX * i, y);
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
    /**
     * Draws the background with 3 ghosts
     *
     * @param g graphics
     */
    public static void drawBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLUE);
        g.fillRect(0, 30, WIDTH, 5);
        g.fillRect(0, 85, WIDTH, 5);
        g.fillRect(0, 140, WIDTH, 5);
        g.fillRect(0, 195, WIDTH, 5);
        g.fillRect(0, 250, WIDTH, 5);
        g.fillRect(0, 305, WIDTH, 5);
        g.fillRect(0, 360, WIDTH, 5);

        g.setColor(Color.MAGENTA);
        g.fillOval(30, 40, 40, 35);
        g.fillRect(30, 60, 40, 20);
        g.setColor(Color.BLACK);
        g.fillOval(35, 50, 10, 10);
        g.fillOval(55, 50, 10, 10);
        Polygon triangle1 = new Polygon();
        triangle1.addPoint(40, 70);
        triangle1.addPoint(30, 80);
        triangle1.addPoint(50, 80);
        g.fillPolygon(triangle1);
        Polygon triangle2 = new Polygon();
        triangle2.addPoint(60, 70);
        triangle2.addPoint(50, 80);
        triangle2.addPoint(70, 80);
        g.fillPolygon(triangle2);

        g.setColor(Color.CYAN);
        g.fillOval(430, 150, 40, 35);
        g.fillRect(430, 170, 40, 20);
        g.setColor(Color.BLACK);
        g.fillOval(435, 160, 10, 10);
        g.fillOval(455, 160, 10, 10);
        Polygon triangle3 = new Polygon();
        triangle3.addPoint(440, 180);
        triangle3.addPoint(430, 190);
        triangle3.addPoint(450, 190);
        g.fillPolygon(triangle3);
        Polygon triangle4 = new Polygon();
        triangle4.addPoint(460, 180);
        triangle4.addPoint(450, 190);
        triangle4.addPoint(470, 190);
        g.fillPolygon(triangle4);

        g.setColor(Color.RED);
        g.fillOval(230, 315, 40, 35);
        g.fillRect(230, 335, 40, 20);
        g.setColor(Color.BLACK);
        g.fillOval(235, 325, 10, 10);
        g.fillOval(255, 325, 10, 10);
        Polygon triangle5 = new Polygon();
        triangle5.addPoint(240, 345);
        triangle5.addPoint(230, 355);
        triangle5.addPoint(250, 355);
        g.fillPolygon(triangle5);
        Polygon triangle6 = new Polygon();
        triangle6.addPoint(260, 345);
        triangle6.addPoint(250, 355);
        triangle6.addPoint(270, 355);
        g.fillPolygon(triangle6);
    }
    
    /**
     * Draws pacman
     *
     * @param g graphics
     * @param x x-coordinate of initial position
     * @param y y-coordinate of initial position
     */
    public static void drawFigure(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 50, 50);

        g.setColor(Color.BLACK);
        g.fillOval(x + 30, y + 5, 7, 7);

        Polygon triangle = new Polygon();
        triangle.addPoint(x + 25, y + 25);
        triangle.addPoint(x + 50, y);
        triangle.addPoint(x + 50, y + 50);
        g.fillPolygon(triangle);
    } 
}