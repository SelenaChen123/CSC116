import java.util.Random;
import java.util.Scanner;

/**
 *
 * Program does multiple things with arrays.
 *
 * @author Selena Chen
 * @author Ayushi Verma
 *
 */
public class IntArrayAlgorithms {

    /**
     * Creates an array with given length and stores the values that are given from
     * the user.
     * 
     * @param length The length of the array that will be created and returned
     * @return Array with length elements that were given by the user
     */
    public static int[] getArrayFromUser(int length) {
        int[] arr = new int[length];
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element " + i + " (Integer): ");
            while (!console.hasNextInt()) {
                console.next(); // discard token
                System.out.println("Not an integer.");
                System.out.print("Element " + i + " (Integer): ");
            }
            arr[i] = console.nextInt();
        }
        return arr;
    }

    /**
     * Creates an array with given length and stores the random values between 0 and
     * (bound-1)
     * 
     * @param length The length of the array that will be created and returned
     * @param bound The upperbound for the range of values within the array
     * @return Array with length elements that were assigned random integers
     */
    public static int[] getRandomArray(int length, int bound) {
        Random r = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(bound);
        }
        return arr;
    }
    
    /**
     * Returns the contents of the array as a String in the format
     * {[val],[val],..[val]}
     * 
     * @param arr Array to return as a String
     * @return String format ({[val],[val],..[val]}) of arr
     */
    public static String arrayAsString(int[] arr) {
        String ret = "{";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i < arr.length - 1) {
                ret += ", ";
            }
        }
        ret += "}";
        return ret;
    }

    /**
     *
     * Returns the last index at which the value occurs in the array
     *
     * @param arr user-inputted array
     * @param value user-inputted integer being searched for
     * @return index last index of the value
     *
     */
    public static int lastIndexOf(int[] arr, int value) {
        int index = -1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == value) {
                index = i;
                return index;
            }
        }
        return index;
    }

    /**
     *
     * Returns the range of values in an array of integers
     *
     * @param arr user-inputted array
     * @return range range of values in the array
     *
     */
    public static int range(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int range = 0;
        for(int element : arr) {
            if(element < min) {
                min = element;
            }
            if(element > max) {
                max = element;
            }
        }
        range = max - min + 1;
        return range;
    }

    /**
     *
     * Returns the count of how many elements from the array fall between the minimum and maximum
     *
     * @param arr user-inputted array
     * @param min user-inputted minimum value
     * @param max user-inputted maximum value
     * @return count counter of values within the given range
     *
     */
    public static int countInRange(int[] arr, int min, int max) {
        int count = 0;
        for(int element : arr) {
            if(element >= min && element <= max) {
                count++;
            }
        }
        return count;
    }
}
