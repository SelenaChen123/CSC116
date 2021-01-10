import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests SmallestDivisor
 * 
 * @author Jessica Young Schmidt
 */
public class SmallestDivisorTest extends TestCase {

    /**
     * Tests smallestDivisor method
     */
    @Test
    public void testSmallestDivisor() {
        assertEquals("2", 2, SmallestDivisor.smallestDivisor(2));
        assertEquals("5", 5, SmallestDivisor.smallestDivisor(5));
        assertEquals("9", 3, SmallestDivisor.smallestDivisor(9));
        assertEquals("20", 2, SmallestDivisor.smallestDivisor(20));
        try {
            SmallestDivisor.smallestDivisor(-20);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Negative", "Invalid integer: -20", e.getMessage());
        }
    }

}
