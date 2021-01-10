/**
 * An fruit that can be sold at a stand. The fruit knows its type, color, how
 * many are available, and its price as an int.
 * 
 * @author Selena Chen
 */
public class Fruit {
    /** Fruit's type */
    private String type;

    /** Fruit's color */
    private String color;
    
    /** Fruit's quantity */
    private int quantity;

    /** Fruit's price */
    private int price;

    /**
     * Creates a fruit with the given information. If the quantity or price are
     * less than 0, an IllegalArgumentException is thrown.
     * 
     * @param type type of fruit
     * @param color the color of the fruit
     * @param quantity number of fruits available for purchase
     * @param price price of fruit to the penny
     * @throws IllegalArgumentException if the quantity or price are less than 0
     */
    public Fruit(String type, String color, int quantity, int price) {
        this.type = type;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Sets the fruit's quantity to the given value. If the parameter is less
     * than 0, an IllegalArgumentException is thrown.
     * 
     * @param quantity number of fruits available for purchase
     * @throws IllegalArgumentException if the quantity is less than 0.
     */
    public void setQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException();
        }
        this.quantity = quantity;
    }

    /**
     * Sets the price for the fruit to the given value. If the parameter is less
     * than 0, an IllegalArgumentException is thrown.
     * 
     * @param price cost of the fruit as an int
     * @throws IllegalArgumentException if the prices is less than 0
     */
    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    /**
     * Returns true if there is quantity available to purchase a fruit. If a
     * fruit is purchased, the quantity is decremented. Returns false if the
     * quantity is 0.
     * 
     * @return true if there is quantity available to purchase
     */
    public boolean purchaseFruit() {
        if(quantity > 0) {
            quantity--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the fruit's type.
     * 
     * @return the fruit's type
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the amount of the fruit in quantity.
     * 
     * @return the amount of the fruit in quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the price as a double for display purposes.
     * 
     * @return the price as a double
     */
    public double getPrice() {
        return price / 100.0;
    }

    /**
     * Returns a String representation of the fruit.
     * 
     * @return a String representation of the fruit
     */
    public String toString() {
        if (quantity == 0) {
            return type + " is not available.";
        }
        return type + " is available at $" + getPrice();
    }

}
