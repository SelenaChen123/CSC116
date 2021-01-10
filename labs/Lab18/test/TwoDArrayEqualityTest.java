import static org.junit.Assert.*;

import org.junit.Test;

public class TwoDArrayEqualityTest {

    @Test
    public void testEquals2DIntA() {
        int[][] ints8 = { { 1 }, { 2, 3 } };
        assertTrue(TwoDArrayEquality.equals2D(ints8, ints8));

    }

    @Test
    public void testEquals2DIntB() {
        int[][] ints8 = { { 1 }, { 2, 3 } };
        int[][] ints9 = { { 2, 3 }, { 1 } };
        assertFalse(TwoDArrayEquality.equals2D(ints8, ints9));
        assertFalse(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DIntC() {
        int[][] ints8 = { { -1 }, { 2, 3 } };
        int[][] ints9 = { { -1 }, { 2, 3 } };
        assertTrue(TwoDArrayEquality.equals2D(ints8, ints9));
        assertTrue(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DIntD() {
        int[][] ints8 = { { -1 }, { 2, 3 } };
        int[][] ints9 = { { 2, 3 }, { -1 } };
        assertFalse(TwoDArrayEquality.equals2D(ints8, ints9));
        assertFalse(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DIntE() {
        int[][] ints8 = { { 1 }, { 2 } };
        int[][] ints9 = { { 2 }, { 1 } };
        assertFalse(TwoDArrayEquality.equals2D(ints8, ints9));
        assertFalse(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DIntF() {
        int[][] ints8 = { { 1 }, { 2 } };
        int[][] ints9 = { { 1 }, { 2 } };
        assertTrue(TwoDArrayEquality.equals2D(ints8, ints9));
        assertTrue(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DIntG() {
        int[][] ints8 = { { 1 } };
        int[][] ints9 = { { 1 }, { 2, 3 } };
        assertFalse(TwoDArrayEquality.equals2D(ints8, ints9));
        assertFalse(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DStringA() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        assertTrue(TwoDArrayEquality.equals2D(strings1, strings1));
    }

    @Test
    public void testEquals2DStringB() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat", "dog", "Puppy" }, { "A", "B", "C" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringC() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        assertTrue(TwoDArrayEquality.equals2D(strings1, strings3));
        assertTrue(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringD() {
        String[][] strings1 = { { "Dog", "Cat", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringE() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "A", "B", "C" }, { "Cat", "Dog", "Puppy" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringF() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat", "Dog", "Puppy" }, { "a", "b", "c" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringG() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat ", "Dog", "Puppy" }, { "A", "B", "C" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }
}
