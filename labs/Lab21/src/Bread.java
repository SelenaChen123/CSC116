/**
 * Creates Bread object that can take in parameters for bread type and
 * calories per slice, get the bread type and calories per type, convert to
 * String, and check whether two Bread objects are equal or not.
 *
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class Bread {
    /** Bread type */
    private String bread;
    /** Calories per slice */
    private int caloriesPerSlice;

    /**
     * Constructor that takes in parameters for a Bread object
     *
     * @param bread bread type
     * @param caloriesPerSlice calories per slice
     */
    public Bread(String bread, int caloriesPerSlice) {
        this.bread = bread;
        this.caloriesPerSlice = caloriesPerSlice;
    }

    /**
     * Gets the bread type
     *
     * @return bread bread type
     */
    public String getBread() {
        return bread;
    }

    /**
     * Gets the calories per slice
     *
     * @return caloriesPerSlice calories per slice
     */
    public int getCaloriesPerSlice() {
        return caloriesPerSlice;
    }

    /**
     * Converts to string
     *
     * @return String version of Bread
     */
    public String toString() {
        String tempBread = bread.toUpperCase();
        tempBread = tempBread.substring(0, 1);
        return tempBread + bread.substring(1) + " (" + caloriesPerSlice
                + " calories per slice)";
    }

    /**
     * Checks whether or not two Bread objects are equal
     *
     * @param other object being compared to
     * @return true or false
     */
    public boolean equals(Object other) {
        if(other instanceof Bread) {
            Bread b = (Bread) other;
            return bread.equals(b.getBread())
                    && caloriesPerSlice == b.getCaloriesPerSlice();
        } else {
            return false;
        }
    }
}
