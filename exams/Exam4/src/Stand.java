/**
 * Represents a Stand that sells a number of Fruits.
 * 
 * @author Selena Chen
 */
public class Stand {

    /** Maximum number of fruits that can be sold in the stand */
    private static final int NUM_PRODUCTS = 20;
    /** Collection of fruits for sale */
    private Fruit[] products;
    /** Number of fruits in the products array */
    private int size;

    /**
     * Constructs an array of fruits that has space for the maximum number of
     * fruits that can be sold in the stand. The size is initialized to 0, which
     * means the stand starts with no products.
     */
    public Stand() {
        size = 0;
        products = new Fruit[NUM_PRODUCTS];
    }

    /**
     * Returns true if the fruit with the given information is added to the list
     * of products for the stand. If the collection of products is full, false
     * is returned. This method allows the IllegalArgumentException that may be
     * thrown from constructing a fruit pass through to the UI.
     * 
     * @param type type of fruit
     * @param color color of the fruit
     * @param quantity number of fruits available for purchase
     * @param price price of fruit to the penny
     * @return true if the fruit with the given information is added
     * @throws IllegalArgumentException if the quantity or price are less than 0
     */
    public boolean addProduct(String type, String color, int quantity, int price) {
        if(size == NUM_PRODUCTS) {
            return false;
        } else {
            products[size] = new Fruit(type, color, quantity, price);
            size++;
            return true;
        }
    }

    /**
     * Returns true if there is enough inventory/quantity to purchase a fruit
     * stand in the products array at the given index. If the idx is less than
     * zero or greater than or equal to size, an IllegalArgumentException is
     * thrown.
     * 
     * @param idx index to purchase a product from
     * @return true if the product could be purchased
     * @throws IllegalArgumentException if the idx is out of bounds
     */
    public boolean purchaseProduct(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException();
        }
        if (products[idx] != null) {
            return products[idx].purchaseFruit();
        }
        return false;
    }

    /**
     * Returns a string representation of the products in the stand.
     * 
     * @return a string representation of the products in the stand
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += i + ". " + products[i].toString() + "\n";
        }
        return s;
    }

}
