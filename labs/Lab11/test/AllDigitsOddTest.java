import static org.junit.Assert.assertEquals;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This program tests AllDigitsOdd
 * 
 * @author Selena Chen
 * @author Armaan Syed
 *
 */
public class AllDigitsOddTest extends TestCase {
    @Test
    public void testAllDigitsOdd() {
        String description = "Testing invalid input with first user prompt";
        boolean expected = false;
        boolean actual = AllDigitsOdd.areAllDigitsOdd(12);
        assertEquals(description, expected, actual);

        description = "Testing single digit odd input";
        expected = true;
        actual = AllDigitsOdd.areAllDigitsOdd(1);
        assertEquals(description, expected, actual);

        description = "Testing multi-digit input with an even digit";
        expected = false;
        actual = AllDigitsOdd.areAllDigitsOdd(123);
        assertEquals(description, expected, actual);

        description = "Testing multi-digit input with all odd digits";
        expected = true;
        actual = AllDigitsOdd.areAllDigitsOdd(1357);
        assertEquals(description, expected, actual);

        description = "Testing single digit even input";
        expected = false;
        actual = AllDigitsOdd.areAllDigitsOdd(2);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testLastDigit() {
        String description = "Testing multi-digit input";
        int expected = 3;
        int actual = AllDigitsOdd.lastDigit(123);
        assertEquals(description, expected, actual);

        description = "Testing single-digit input";
        expected = 1;
        actual = AllDigitsOdd.lastDigit(1);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testWithoutLastDigit() {
        String description = "Testing multi-digit input";
        int expected = 12;
        int actual = AllDigitsOdd.withoutLastDigit(123);
        assertEquals(description, expected, actual);

        description = "Testing single-digit input";
        expected = 0;
        actual = AllDigitsOdd.withoutLastDigit(1);
        assertEquals(description, expected, actual);
    }
}