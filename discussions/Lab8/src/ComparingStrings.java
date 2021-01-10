/**
 * This program implements an equals method for String then compares it to
 * String's equals method
 * 
 * @author Jessica Young Schmidt
 * @author CSC116-002-f18
 */
public class ComparingStrings {
    /**
     * Starts program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        compareStrings("CSC", "csc");
        compareStrings("CSC", "CSC");
        compareStrings("CSC", "CSC116");
        compareStrings("CSC116 - Intro to Computing", "CSC116 - Intro to Computing");
        compareStrings("CSC116 - Intro to Computing", "CSC116 - Intro to Computing!");
        compareStrings("CSC", "");
        compareStrings("", "");

    }

    /**
     * Prints output for comparing Strings with String equals methods and our
     * String equals method
     * 
     * @param string1 first String to compare
     * @param string2 second String to compare
     */
    public static void compareStrings(String string1, String string2) {
        System.out.println("Compare \"" + string1 + "\" & \"" + string2 + "\": String equals - "
                        + string1.equals(string2) + ", our equals method - "
                        + equals(string1, string2));
    }

    /**
     * Compares two strings to determine if they are equal (contain all of the
     * same characters in the same order)
     * 
     * @param string1 first String to compare
     * @param string2 second String to compare
     * @return whether string1 and string2 are equal
     */
    public static boolean equals(String string1, String string2) {
        if(string1.length() != string2.length()){
            return false;
        }
        // ASSERT: same length
        for(int i = 0; i < string1.length(); i++){
            if(string1.charAt(i) != string2.charAt(i)){
                return false;
            } 
        }
        // ASSERT: same strings
        return true;
    }

}






