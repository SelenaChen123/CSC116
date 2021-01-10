import java.util.Scanner;

/**
 * User interface for the stand application.
 * 
 * @author Selena Chen
 */
public class StandUI {

    /** Console scanner for processing user input */
    private Scanner console;
    /** Reference to the underlying stand model */
    private Stand stand;

    /**
     * Constructs a StandUI object by creating a console scanner and the Stand
     * object.
     */
    public StandUI() {
        console = new Scanner(System.in);
        stand = new Stand();
    }

    /**
     * Main menu that provides options for adding items, purchasing items, and
     * quitting the program.
     */
    public void mainMenu() {
        while (true) {
            System.out
                    .println("Welcome to the Stand.  Select one of the following options.");
            System.out.println("(A)dd a fruit to the product list");
            System.out.println("(P)urchase a fruit");
            System.out.println("(Q)uit");
            System.out.print("Option? ");

            String input = console.nextLine();
            if (input.toLowerCase().charAt(0) == 'a') {
                addFruit();
            } else if (input.toLowerCase().charAt(0) == 'p') {
                purchaseFruit();
            } else if (input.toLowerCase().charAt(0) == 'q') {
                System.exit(0);
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    /**
     * User interface for adding a fruit to the stand.
     */
    public void addFruit() {
        // Get fruit type
        System.out.print("Fruit type? ");
        String type = console.nextLine();

        // Get fruit color
        System.out.print("Fruit color? ");
        String color = console.nextLine();

        // Get quantity
        while (true) {
            System.out.print("Quantity? ");
            if (console.hasNextInt()) {
                break;
            }
            console.nextLine(); // throw away input
            System.out.println("Quantity must be an int.");
        }
        int quantity = console.nextInt();
        console.nextLine(); // throw away rest of input

        // Get item price
        while (true) {
            System.out.print("Item price in pennies (int)? ");
            if (console.hasNextInt()) {
                break;
            }
            console.nextLine(); // throw away input
            System.out.println("Item price must be an int.");
        }

        int price = console.nextInt();
        console.nextLine(); // throw away rest of input

        try {
            if (stand.addProduct(type, color, quantity, price)) {
                System.out.println("Fruit successfully added.");
            } else {
                System.out.println("No more room in the stand.");
            }
        } catch (IllegalArgumentException e) {
            System.out
                    .println("Invalid fruit information.  Fruit could not be created.");
        }
    }

    /**
     * User interface for purchasing a fruit from the stand.
     */
    public void purchaseFruit() {
        System.out.println(stand.toString());

        // Get index number to purchase
        while (true) {
            System.out.println("Fruit to Purchase? ");
            if (console.hasNextInt()) {
                break;
            }
            console.nextLine(); // throw away input
            System.out.println("Fruit to purchase must be an int.");
        }

        int idx = console.nextInt();
        console.nextLine(); // throw away rest of line

        try {
            if (stand.purchaseProduct(idx)) {
                System.out.println("Fruit successfully purchased.");
            } else {
                System.out
                        .println("Fruit could not be purchased due to lack of quantity.");
            }
        } catch (IllegalArgumentException e) {
            System.out
                    .println("Invalid fruit number.  Fruit could not be purchased.");
        }
    }

    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        StandUI ui = new StandUI();
        ui.mainMenu();
    }

}
