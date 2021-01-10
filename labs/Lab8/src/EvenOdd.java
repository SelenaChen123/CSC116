import java.util.Scanner;
/** 
 * Determines whether user-inputted integer is odd or even
 * 
 * @author Ayushi Verma
 * @author Selena Chen
 */
public class EvenOdd {
    /**
    * Starts program
    * @param args command line arguments
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int integer = in.nextInt();
        evenOdd(integer);
    }

    /**
    * Prints whether integer is even or not
    * @param integer user-inputted integer
    * @return Even or Odd string
    */
    public static String evenOdd(int integer) {
        if (integer % 2 == 0) {
            return "Even";
        } 
        else {
            return "Odd";    
        } 
    }
}
