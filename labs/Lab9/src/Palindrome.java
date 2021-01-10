import java.util.*;

/**
 * Determines if a user entered String is a palindrome, which means the String
 * is the same forward and reverse. The determination is case-insensitive.
 * Spaces and punctuation must match for palindromes.
 * 
 * @author Dr. Sarah Heckman
 * @author Dr. Jessica Young Schmidt
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class Palindrome {

    /**
     * Starts program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) {
        printPalindrome("abba"); // palindrome
        printPalindrome("racecar"); // palindrome
        printPalindrome("Madam"); // palindrome
        printPalindrome("!!!Hannah!!!"); // palindrome
        printPalindrome("! ! ! Hannah ! ! !"); // palindrome
        printPalindrome("Dot saw I was tod"); // palindrome
        printPalindrome("Step on no pets"); // palindrome
        printPalindrome("Step on no pets!"); // NOT
        printPalindrome("dog"); // NOT
        printPalindrome("Java"); // NOT
        printPalindrome("states"); // NOT
        printPalindrome("abca"); // NOT
        printPalindrome("abaaca"); // NOT
        printPalindrome("Was It A Rat I Saw");// NOT
        System.out.println("\n*****Read from User*****");
        readConsole();
    }

    /**
     * Reads user's console input and prints the results
     */
    public static void readConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String text = in.nextLine();
        printPalindrome(text);
    }

    /**
     * Prints whether text is a palindrome
     * 
     * @param text String to check whether it is a palindrome
     */
    public static void printPalindrome(String text) {
        System.out.print("isPalindrome: \t");
        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a palindrome");
        } else {
            System.out.println("\"" + text + "\" is NOT a palindrome");
        }
    }

    /**
     * Returns true if the text is a palindrome - the same word forward and
     * backwards
     * 
     * @param text String object to test if palindrome
     * @return whether text is a palindrome
     */
    public static boolean isPalindrome(String text) {
        text = text.toLowerCase();
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
