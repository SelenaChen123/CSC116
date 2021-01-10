import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program to test IntArrayAlgorithms
 * 
 * @author Jessica Young Schmidt
 * @author Ayushi Verma
 * @author Selena Chen
 */

public class ArrayHelpersTest extends TestCase {

    @Test
    public void testAllLessA() {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 5, 6 };
        assertTrue(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }

    @Test
    public void testAllLessB() {
        int[] arr1 = { 1, 2, -3 };
        int[] arr2 = { 4, 5, 6 };
        assertTrue(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }

    @Test
    public void testAllLessC() {
        int[] arr1 = { 2, 2, 2 };
        int[] arr2 = { 2, 2, 2 };
        assertFalse(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }

    @Test
    public void testAllLessD() {
        int[] arr1 = { 1, 2, 3, 3};
        int[] arr2 = { 4, 5, 6 };
        assertFalse(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }

    @Test
    public void testAllLessE() {
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 1, 1 };
        assertFalse(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }



    @Test
    public void testSwapPairsA() {
        int[] arrSwapA = { 10, 20, 30, 40, 50 };
        int[] arrSwapAExp = { 20, 10, 40, 30, 50 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }

    @Test
    public void testSwapPairsB() {
        int[] arrSwapA = { 10, 20, 30, 40 };
        int[] arrSwapAExp = { 20, 10, 40, 30 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }
    
    @Test
    public void testSwapPairsC() {
        int[] arrSwapA = { 10 };
        int[] arrSwapAExp = { 10 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }

    @Test
    public void testSwapPairsD() {
        int[] arrSwapA = { 10, 20 };
        int[] arrSwapAExp = { 20, 10 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }

}
