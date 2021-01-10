import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Stand class
 * 
 * @author Jessica Young Schmidt
 *
 */
public class StandTest extends TestCase {
    private Stand stand;

    @Before
    public void setUp() throws Exception {
        stand = new Stand();
    }

    @Test
    public void testInitialSetup() {
        assertEquals("toString", "", stand.toString());
    }

    @Test
    public void testAddPurchase() {
        assertTrue("Add product", stand.addProduct("Item 1", "Red", 0, 340));
        assertEquals("toString", "0. Item 1 is not available.\n",
                stand.toString());
        assertTrue("Add product", stand.addProduct("Item 2", "White", 10, 340));
        assertEquals("toString", "0. Item 1 is not available.\n"
                + "1. Item 2 is available at $3.4\n", stand.toString());
        try {
            stand.purchaseProduct(-10);
        } catch (IllegalArgumentException e) {
            assertTrue("Threw IllegalArgumentException for negative index",
                    true);
        }
        try {
            stand.purchaseProduct(10);
        } catch (IllegalArgumentException e) {
            assertTrue("Threw IllegalArgumentException for size index", true);
        }
        assertFalse("Purchase item that has no inventory",
                stand.purchaseProduct(0));
        assertTrue("Add product", stand.addProduct("Item 3", "Red", 10, 340));
        assertEquals("toString",
                "0. Item 1 is not available.\n"
                        + "1. Item 2 is available at $3.4\n"
                        + "2. Item 3 is available at $3.4\n",
                stand.toString());

        assertTrue("Add product", stand.addProduct("Item 4", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 5", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 6", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 7", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 8", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 9", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 10", "Red", 10, 340));

        assertTrue("Add product", stand.addProduct("Item 4", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 5", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 6", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 7", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 8", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 9", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 10", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 8", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 9", "Red", 10, 340));
        assertTrue("Add product", stand.addProduct("Item 10", "Red", 10, 340));
        assertFalse("Add product", stand.addProduct("Item 11", "Red", 10, 340));
        assertFalse("Add product", stand.addProduct("Item 12", "Red", 10, 340));
    }

}
