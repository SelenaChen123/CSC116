import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Fruit Class
 * 
 * @author Jessica Young Schmidt
 *
 */
public class FruitTest extends TestCase {
    private static double DELTA = 0.01;
    private Fruit fruit;

    @Before
    public void setUp() throws Exception {
        fruit = new Fruit("Strawberry", "Red", 3, 555);
    }

    @Test
    public void testConstructorExceptions() {
        try {
            new Fruit("Fruit", "Red", -5, 10);
        } catch (IllegalArgumentException e) {
            assertTrue("Threw IllegalArgumentException for negative quantity",
                    true);
        }
        try {
            new Fruit("Fruit", "Red", 45, -10);
        } catch (IllegalArgumentException e) {
            assertTrue("Threw IllegalArgumentException for negative price",
                    true);
        }
    }

    @Test
    public void testSettersGetters() {
        assertEquals("Get Type", "Strawberry", fruit.getType());
        assertEquals("Get Quantity", 3, fruit.getQuantity());
        assertEquals("Get Price", 5.55, fruit.getPrice(), DELTA);
        try {
            fruit.setQuantity(-3);
        } catch (IllegalArgumentException e) {
            assertTrue("Threw IllegalArgumentException for negative quantity",
                    true);
        }
        try {
            fruit.setPrice(-1);
        } catch (IllegalArgumentException e) {
            assertTrue("Threw IllegalArgumentException for negative price",
                    true);
        }

        fruit.setQuantity(55);
        fruit.setPrice(10);
        assertEquals("Get Quantity", 55, fruit.getQuantity());
        assertEquals("Get Price", 0.1, fruit.getPrice(), DELTA);
    }

    @Test
    public void testPurchaseToString() {
        assertEquals("toString", "Strawberry is available at $5.55",
                fruit.toString());
        assertTrue("Purchase item", fruit.purchaseFruit());
        assertEquals("Get Quantity", 2, fruit.getQuantity());
        assertEquals("toString", "Strawberry is available at $5.55",
                fruit.toString());
        assertTrue("Purchase item", fruit.purchaseFruit());
        assertEquals("Get Quantity", 1, fruit.getQuantity());
        assertEquals("toString", "Strawberry is available at $5.55",
                fruit.toString());
        assertTrue("Purchase item", fruit.purchaseFruit());
        assertEquals("Get Quantity", 0, fruit.getQuantity());
        assertEquals("toString", "Strawberry is not available.",
                fruit.toString());
        assertFalse("Purchase item", fruit.purchaseFruit());
        assertEquals("Get Quantity", 0, fruit.getQuantity());
        assertEquals("toString", "Strawberry is not available.",
                fruit.toString());

    }

}
