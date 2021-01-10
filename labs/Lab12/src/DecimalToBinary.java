import java.util.Scanner;

/**
 *
 * Converts user-inputted decimal integer to binary string
 *
 * @author Selena Chen
 * @author Armaan Syed
 * @author Pascal Le
 *
 */
public class DecimalToBinary {
   /**
    *
    * Starts the program
    *
    * @param args command line arguments
    *
    */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int decimal = 0;
        while(decimal != -1) {
            System.out.print("Enter a number (-1 to quit): ");
            while(!console.hasNextInt()) {
                console.next();
                System.out.println("Not an int, try again");
                System.out.print("Enter a number (-1 to quit): ");
            }
            decimal = console.nextInt();
            if(decimal < -1) {
                while(decimal < -1) {
                    System.out.println("Need a nonnegative number or -1 to quit");
                    System.out.print("Enter a number (-1 to quit): ");
                    decimal = console.nextInt();
                }
            }
            if(decimal != -1) {
                System.out.println("Decimal: " + decimal + ", Binary: "
                                    + convertToBinary(decimal));
            }
        }
        System.out.println("Exiting DecimalToBinary");
    }

    /**
    *
    * Converts user-inputted decimal integer to binary string
    *
    * @param decimal user-inputted decimal integer
    * @return binaryString decimal integer converted to binary string
    *
    */
    public static String convertToBinary(int decimal) {
        if(decimal < 0) {
            throw new IllegalArgumentException("Negative value: " + decimal);
        }
        String binary = "";
        do {
            int binaryDigit = decimal % 2;
            binary = binary + binaryDigit;
            decimal /= 2;
        } while (decimal != 0);
        String binaryString = "";
        for(int i = binary.length() - 1; i >= 0; i--) {
            binaryString += binary.charAt(i);
        }
        return binaryString;
    }
}




