/**
 * Creates Sandwich object that can take in parameters either with Bread and
 * SandwichFilling objects or String bread, int caloriesPerSlice, String
 * filling, and int calories parameters, calculate the total calories in the
 * sandwich, convert to String, and check whether two Sandwich objects are
 * equal or not.
 *
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class Sandwich {
    /** Bread object */
    private Bread bread;
    /** SandwichFilling object */
    private SandwichFilling filling;

    /**
     * Constructor that takes in object parameters for a Sandwich object
     *
     * @param bread Bread object
     * @param filling SandwichFilling object
     */
    public Sandwich(Bread bread, SandwichFilling filling) {
        this.bread = bread;
        this.filling = filling;
    }

    /**
     * Constructor that takes in non-object parameters for a Sandwich object
     *
     * @param bread bread type
     * @param caloriesPerSlice calories per slice
     * @param filling filling type
     * @param calories calories per serving
     */
    public Sandwich(String bread, int caloriesPerSlice, String filling,
                    int calories) {
        this(new Bread(bread, caloriesPerSlice),
                new SandwichFilling(filling, calories));
    }

    /**
     * Assumes Sandwich is made using two slices of Bread and calculates total
     * number of calories of the Sandwich
     *
     * @return total total calories
     */
    public int totalCalories() {
        int total = 2 * bread.getCaloriesPerSlice() + filling.getCalories();
        return total;
    }

    /**
     * Converts to string
     *
     * @return String version of Sandwich
     */
    public String toString() {
        String tempFilling = filling.toString().toUpperCase();
        tempFilling = tempFilling.substring(0, 1);
        return "Total Calories (" + this.totalCalories() + "): "
                + filling.toString() + " on " + bread.toString();
    }

    /**
     * Checks whether or not two Sandwich objects are equal
     *
     * @param other object being compared to
     * @return true or false
     */
    public boolean equals(Object other) {
        if(other instanceof Sandwich) {
            Sandwich s = (Sandwich) other;
            return this.bread.equals(s.bread)
                    && this.filling.equals(s.filling);
        } else {
            return false;
        }
    }
}
