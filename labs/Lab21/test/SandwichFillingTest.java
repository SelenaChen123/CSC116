import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SandwichFillingTest extends TestCase {
    private SandwichFilling turkey;
    private SandwichFilling ham;

    @Before
    public void setUp() {
        turkey = new SandwichFilling("Turkey", 54);
        ham = new SandwichFilling("Ham", 203);
    }

    @Test
    public void testGetters() {
        assertEquals("Turkey type", "Turkey", turkey.getFilling());
        assertEquals("Turkey calories", 54, turkey.getCalories());
    }

    @Test
    public void testGetFilling() {
        assertEquals("Ham type", "Ham", ham.getFilling());
    }

    @Test
    public void testGetCalories() {
        assertEquals("Ham calories", 203, ham.getCalories());
    }

    @Test
    public void testEquals1() {
        assertTrue(turkey.equals(turkey));
        assertTrue(turkey.equals(new SandwichFilling("Turkey", 54)));
        assertFalse(turkey.equals(new SandwichFilling("Turkey", 60)));
        assertFalse(turkey.equals(new SandwichFilling("turkey", 54)));
        assertFalse(turkey.equals(null));
        assertFalse(turkey.equals("Hello"));
    }

    @Test
    public void testEquals2() {
        assertTrue(ham.equals(ham));
        assertTrue(ham.equals(new SandwichFilling("Ham", 203)));
        assertFalse(ham.equals(new SandwichFilling("Turkey", 203)));
        assertFalse(ham.equals(new SandwichFilling("ham", 203)));
        assertFalse(ham.equals(null));
        assertFalse(ham.equals("Hello"));
    }

    @Test
    public void testToString1() {
        assertEquals("Turkey (54 calories per serving)", turkey.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Ham (203 calories per serving)", ham.toString());
    }
}
