import java.util.Scanner;

/**
 * Finds the smallest divisor of an integer
 * 
 * @author Jessica Young Schmidt
 * @author CSC116-002 (Fall 2018)
 */
public class ReadIntegers {

    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int total = 0;
        int num = 0;
        int previous;
        do{
            previous = num;
            System.out.print("Enter int: ");
            while(!in.hasNextInt()){
                in.next();
                System.out.print("Enter int: ");
            }
            num = in.nextInt();
            total += num;
        } while (num != 0 && previous != num);
        
        System.out.println("Total: " + total);
    }
}