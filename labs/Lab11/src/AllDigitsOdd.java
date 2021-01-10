import java.util.Scanner;

/**
 *
 * Takes an integer and returns whether every digit of an integer is odd
 *
 * @author Selena Chen
 * @author Armaan Syed
 *
 */
public class AllDigitsOdd {
    /**
    *
    * Starts the program
    *
    * @param args command line arguments
    *
    */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter integer: ");
        while(!console.hasNextInt()) {
            console.next();
            System.out.print("Please enter an integer: ");
        }
        int integer = console.nextInt();
        System.out.println("areAllDigitsOdd(" + integer + "): " + areAllDigitsOdd(integer));
    }

    /**
    *
    * Takes an integer and returns whether every digit of an integer is odd
    *
    * @param integer user-inputted integer
    * @return true or false
    *
    */
    public static boolean areAllDigitsOdd(int integer) {
        if(lastDigit(integer) % 2 == 0) {
            return false;
        } else {
            if(integer % 10 == integer) {
                if (integer % 2 == 0) {
                    return false;
                }
                return true;
            } else {
                int num = withoutLastDigit(integer);
                if(lastDigit(num) % 2 == 0) {
                    return false;
                }
                while(lastDigit(num) % 2 == 1) {
                    num = withoutLastDigit(num);
                }
                return true;
            }
        }
    }

    /**
    *
    * Returns the absolute value of the last digit
    *
    * @param integer user-inputted integer
    * @return theLastDigit last digit in integer
    *
    */
    public static int lastDigit(int integer) {
        int theLastDigit = integer % 10;
        return theLastDigit;
    }

    /**
    *
    * Returns the absolute value of the digits of the parameter
    * without the last digit
    *
    * @param integer user-inputted integer
    * @return integerWithoutLastDigit integer without the last digit
    *
    */
    public static int withoutLastDigit(int integer) {
        int integerWithoutLastDigit = Math.abs(integer) / 10;
        return integerWithoutLastDigit;
    }
}
