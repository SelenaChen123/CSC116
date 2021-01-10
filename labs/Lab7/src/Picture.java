import java.awt.*;

/**
 * Program that will draw a picture with at least 2 different shapes and colors
 * 
 * @author Selena Chen
 */
public class Picture {
    /**
     * Declares the variables, computes the position, and prints the results.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500, 500);

        // Sets background color
        panel.setBackground(Color.GRAY);

        Graphics g = panel.getGraphics();
        
        // Creates two black eyes
        g.setColor(Color.BLACK);
        g.fillOval(75, 100, 100, 100);
        g.fillOval(325, 100, 100, 100);

        // Creates red mouth
        g.setColor(Color.RED);
        g.fillRect(150, 275, 200, 100);

        // Creates title and my name
        g.setColor(Color.WHITE);
        g.drawString("Mr. Robot", 10, 20);
        g.drawString("Selena Chen", 10, 40);
    }
}