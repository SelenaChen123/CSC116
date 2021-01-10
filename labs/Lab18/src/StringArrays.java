/**
 * Program that performs String array methods
 * 
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class StringArrays {

    /**
     * Checks whether a string array is a palindrome or not
     *
     * @param a String array to examine
     * @return whether a is a palindrome
     */
    public static boolean isPalindrome(String[] a) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != a[a.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
