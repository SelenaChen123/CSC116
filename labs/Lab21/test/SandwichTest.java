import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SandwichTest extends TestCase {
    private Sandwich sandwich;
    private Sandwich sandwich2;

    @Before
    public void setUp() {
        Bread rye = new Bread("Rye", 65);
        SandwichFilling turkey = new SandwichFilling("Turkey", 54);
        sandwich = new Sandwich(rye, turkey);
        Bread white = new Bread("White", 79);
        SandwichFilling ham  = new SandwichFilling("Ham", 203);
        sandwich2 = new Sandwich(white, ham);
    }

    @Test
    public void testTotalCalories() {
        assertEquals("Total Calories", 184, sandwich.totalCalories());
    }

    @Test
    public void testTotalCalories2() {
        assertEquals("Total Calories", 361, sandwich2.totalCalories());
    }

    @Test
    public void testEquals() {
        assertTrue(sandwich.equals(sandwich));
        assertTrue(sandwich.equals(new Sandwich("Rye", 65, "Turkey", 54)));
        assertTrue(sandwich
                .equals(new Sandwich(new Bread("Rye", 65), new SandwichFilling("Turkey", 54))));
        assertFalse(sandwich
                .equals(new Sandwich(new Bread("Rye", 65), new SandwichFilling("turkey", 54))));
        assertFalse(sandwich
                .equals(new Sandwich(new Bread("Rye", 61), new SandwichFilling("Turkey", 54))));
        assertFalse(sandwich.equals(null));
        assertFalse(sandwich.equals("Hello"));
    }

    @Test
    public void testEquals2() {
        assertTrue(sandwich2.equals(sandwich2));
        assertTrue(sandwich2.equals(new Sandwich("White", 79, "Ham", 203)));
        assertTrue(sandwich2
                .equals(new Sandwich(new Bread("White", 79), new SandwichFilling("Ham", 203))));
        assertFalse(sandwich2
                .equals(new Sandwich(new Bread("White", 79), new SandwichFilling("ham", 203))));
        assertFalse(sandwich2
                .equals(new Sandwich(new Bread("White", 61), new SandwichFilling("Ham", 203))));
        assertFalse(sandwich2.equals(null));
        assertFalse(sandwich2.equals("Hello"));
    }

    @Test
    public void testToString() {
        assertEquals("Total Calories (184): Turkey (54 calories per serving) on"
                + " Rye (65 calories per slice)", sandwich.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Total Calories (361): Ham (203 calories per serving) on"
                + " White (79 calories per slice)", sandwich2.toString());
    }
}
