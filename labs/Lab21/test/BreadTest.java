import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BreadTest extends TestCase {

    private Bread rye;
    private Bread white;

    @Before
    public void setUp() {
        rye = new Bread("Rye", 65);
        white = new Bread("White", 79);
    }

    @Test
    public void testGetters1() {
        assertEquals("Rye type", "Rye", rye.getBread());
        assertEquals("Rye calories", 65, rye.getCaloriesPerSlice());
    }

    @Test
    public void testGetBread() {
        assertEquals("White type", "White", white.getBread());
    }

    @Test
    public void testGetCaloriesPerSlice() {
        assertEquals("White calories", 79, white.getCaloriesPerSlice());
    }

    @Test
    public void testEquals1() {
        assertTrue(rye.equals(rye));
        assertTrue(rye.equals(new Bread("Rye", 65)));
        assertFalse(rye.equals(new Bread("Rye", 60)));
        assertFalse(rye.equals(new Bread("rye", 65)));
        assertFalse(rye.equals(null));
        assertFalse(rye.equals("Hello"));
    }

    @Test
    public void testEquals2() {
        assertTrue(white.equals(white));
        assertTrue(white.equals(new Bread("White", 79)));
        assertFalse(white.equals(new Bread("White", 65)));
        assertFalse(white.equals(new Bread("Rye", 79)));
        assertFalse(white.equals(null));
        assertFalse(white.equals("Hello"));
    }

    @Test
    public void testToString1() {
        assertEquals("Rye (65 calories per slice)", rye.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("White (79 calories per slice)", white.toString());
    }
}
