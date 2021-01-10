/**
 * Program determines if two dimensional arrays are equal.
 * 
 * @author Jessica Young Schmidt
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class TwoDArrayEquality {

    /**
     * Test two dimensional arrays (of ints) for equality
     * 
     * @param a first array to examine
     * @param b second array to examine
     * @return whether a and b are equal (contain all of the same elements in the
     *         same order/location)
     */
    public static boolean equals2D(int[][] a, int[][] b) {
        if(a.length != b.length) {
            return false;
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                if(a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Test two dimensional arrays (of Strings) for equality
     * 
     * @param a first array to examine
     * @param b second array to examine
     * @return whether a and b are equal (contain all of the same elements in the
     *         same order/location)
     */
    public static boolean equals2D(String[][] a, String[][] b) {
        if(a.length != b.length) {
            return false;
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                if(a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
