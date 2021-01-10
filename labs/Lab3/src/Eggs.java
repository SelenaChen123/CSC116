/**
* This program displays the amount owed for 38 eggs with a full explanation
* @author Ayushi Verma
* @author Selena Chen
*/
public class Eggs{
    /**
    * Starts program
    * @param args command line arguments
    */
    public static void main(String[] args){
        int numDozen;
        int numEggs = 38;
        int numLoose;
        double totalDozen;
        double totalLoose;
        double total;
    
        numDozen = numEggs / 12;
        numLoose = numEggs % 12;
        totalDozen = numDozen * 3.25;
        totalLoose = numLoose * .45;
        total = totalDozen + totalLoose;
        System.out.println("You ordered " + numEggs + " eggs.  That's " + numDozen + " dozen eggs at $3.25 per dozen and " + numLoose + " loose eggs at $0.45 each for a total of $" + total + ".");
    }
}
