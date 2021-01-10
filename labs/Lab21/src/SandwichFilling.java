/**
 * Creates SandwichFilling object that can take in parameters for filling type
 * and calories per serving, get the filling type and calories per serving,
 * convert to String, and check whether two SandwichFilling objects are equal
 * or not.
 *
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class SandwichFilling {
    /** Filling type */
    private String filling;
    /** Calories per serving */
    private int caloriesPerServing;

    /**
     * Constructor that takes in parameters for a SandwichFilling object
     *
     * @param filling filling type
     * @param caloriesPerServing calories per serving
     */
    public SandwichFilling(String filling, int caloriesPerServing) {
        this.filling = filling;
        this.caloriesPerServing = caloriesPerServing;
    }

    /**
     * Gets the filling type
     *
     * @return filling filling type
     */
    public String getFilling() {
        return filling;
    }

    /**
     * Gets the calories per serving
     *
     * @return caloriesPerServing calories per serving
     */
    public int getCalories() {
        return caloriesPerServing;
    }

    /**
     * Converts to string
     *
     * @return String version of SandwichFilling
     */
    public String toString() {
        String tempFilling = filling.toUpperCase();
        tempFilling = tempFilling.substring(0, 1);
        return tempFilling + filling.substring(1) + " (" + caloriesPerServing
                + " calories per serving)";
    }

    /**
     * Checks whether or not two SandwichFilling objects are equal
     *
     * @param other object being compared to
     * @return true or false
     */
    public boolean equals(Object other) {
        if(other instanceof SandwichFilling) {
            SandwichFilling f = (SandwichFilling) other;
            return filling.equals(f.getFilling())
                    && caloriesPerServing == f.getCalories();
        } else {
            return false;
        }
    }
}
