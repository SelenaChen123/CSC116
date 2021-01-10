/**
 * Program is used to print the powers of two
 * 
 * @author CSC116-002 Fall 2018
 */
public class PowersOfTwo {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        printPowersOf2(3); // 1 2 4 8
        printPowersOf2(10); // 1 2 4 8 16 32 64 128 256 512 1024
    }

    /**
     * Prints the powers of 2 from 2^0 to 2^maxPower
     * 
     * @param maxPower highest power to print
     */
    public static void printPowersOf2(int maxPower) {
        for(int i = 0; i <= maxPower; i++){
            System.out.print(powerOf2(i) + " ");
        }
        System.out.println();
    }

    /**
     * Returns 2^power. Assume power is non-negative
     * 
     * @param power power of two to return
     * @return 2^power
     */
    public static int powerOf2(int power) {  
        int answer = 1;
        for(int i = 1; i <= power; i++){
            answer *= 2;
        }    
        return answer;
        //return (int)Math.pow(2, power);
    }

}








