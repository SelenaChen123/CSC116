import java.util.Scanner;

import org.junit.*;
import junit.framework.TestCase;

/**
 * Tests LabFourteen
 * 
 * @author Jessica Young Schmidt
 */
public class LabFourteenTest extends TestCase {
    /** Single line example */
    public static final String SINGLE_LINE = "apple bat car ";
    /** two line example */
    public static final String TWO_LINES = "apple bat car \ndog elephant ";
    /** three line example */
    public static final String THREE_LINES = "apple bat car \ndog elephant \nfox goat ";

    @Test
    public void testReverseLineSingle() {
        Scanner scan = new Scanner(SINGLE_LINE);
        String expected = "car bat apple \n";
        assertEquals(expected, LabFourteen.reverseLine(scan));
        scan.close();
    }

    @Test
    public void testReverseLineTwo() {
        Scanner scan = new Scanner(TWO_LINES);
        String expected = "car bat apple \nelephant dog \n";
        assertEquals(expected, LabFourteen.reverseLine(scan));
        scan.close();
    }

    @Test
    public void testReverseLineThree() {
        Scanner scan = new Scanner(THREE_LINES);
        String expected = "car bat apple \nelephant dog \ngoat fox \n";
        assertEquals(expected, LabFourteen.reverseLine(scan));
        scan.close();
    }

    @Test
    public void testReverseLineOrderSingle() {
        Scanner scan = new Scanner(SINGLE_LINE);
        String expected = "apple bat car \n";
        assertEquals(expected, LabFourteen.reverseLineOrder(scan));
        scan.close();
    }

    @Test
    public void testReverseLineOrderTwo() {
        Scanner scan = new Scanner(TWO_LINES);
        String expected = "dog elephant \napple bat car \n";
        assertEquals(expected, LabFourteen.reverseLineOrder(scan));
        scan.close();
    }

    @Test
    public void testReverseLineOrderThree() {
        Scanner scan = new Scanner(THREE_LINES);
        String expected = "fox goat \ndog elephant \napple bat car \n";
        assertEquals(expected, LabFourteen.reverseLineOrder(scan));
        scan.close();
    }

}
