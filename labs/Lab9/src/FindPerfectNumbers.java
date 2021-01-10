import java.util.Scanner;
/** 
 * Accepts an integer and returns all perfect numbers up to and including that integer
 * 
 * @author Ayushi Verma
 * @author Selena Chen
 */
public class FindPerfectNumbers {
    /**
    * Starts program
    * @param args command line arguments
    */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = console.nextInt();
        if(num < 0) {
            throw new IllegalArgumentException("Not a positive integer");
        }
        System.out.println(isPerfectNumber(num));
        System.out.println(perfectNumbers(num));
    }

    /**
    * Checks whether a number is a perfect number or not
    * @param number user-inputted integer
    * @return true or false
    */
    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }
        if((sum - number) != number) {
            return false;
        }
        return true;
    }

    /**
    * Prints all perfect numbers up to and including a max integer
    * @param maxNumber user-inputted max integer
    * @return perfectNums all of the perfect numbers up to and including the max integer
    */
    public static String perfectNumbers(int maxNumber) {
        String perfectNums = "";
        for(int i = 1; i <= maxNumber; i++) {
            if(isPerfectNumber(i)) {
                perfectNums = perfectNums + i + " ";
            }
        }
        return perfectNums;
    }
}
