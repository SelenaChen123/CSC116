/**
 * Name class that can get and set a first name, middle initial, and last name, as well as
 * get the normal order of the name, get the reverse order of the name, get the unity ID,
 * get the initials of the name, get the length of the name, get the String version of the name,
 * and check whether two names were equal or not.
 *
 * @author Selena Chen
 * @author Ayushi Verma
 */
public class Name {
    /** First name */
    String first;
    
    /** Middle initial */
    char mid;

    /** Last name */
    String last;
    
    /** Constant integer for the max length of the last name part of unity ID */
    private static final int MAX_LAST_NAME_LENGTH = 6;

    /**
     * Sets the first name
     *
     * @param first first name
     */
    public void setFirstName(String first) {
        this.first = first;
    }

    /**
     * Sets the last name
     *
     * @param last last name
     */
    public void setLastName(String last) {
        this.last = last;
    }

    /**
     * Sets the middle initial
     *
     * @param mid middle initial
     */
    public void setMiddle(char mid) {
        this.mid = mid;
    }

    /**
     * Gets the first name
     *
     * @return first first name
     */
    public String getFirstName() {
        return first;
    }

    /**
     * Gets the middle initial
     *
     * @return mid middle initial
     */
    public char getMiddleInitial() {
        return mid;
    }

    /**
     * Gets the last name
     *
     * @return last last name
     */
    public String getLastName() {
        return last;
    }

    /**
     * Returns a String of the full name in normal order
     *
     * @return first mid. last
     */
    public String getNormalOrder() {
        return first + " " + mid + ". " + last;
    }

    /**
     * Returns a String of the full name in reverse order
     *
     * @return last, first mid.
     */
    public String getReverseOrder() {
        return last + ", " + first + " " + mid + ".";
    }

    /**
     * Returns a String of the unity ID made from the full name
     *
     * @return id unity ID
     */
    public String getUnityID() {
        String firstPart = first.toLowerCase();
        char middlePart = Character.toLowerCase(mid);
        String lastPart = last.toLowerCase();
        if(lastPart.length() > MAX_LAST_NAME_LENGTH) {
            lastPart = lastPart.substring(0, MAX_LAST_NAME_LENGTH);
        }
        firstPart = firstPart.substring(0, 1);
        String id = firstPart + middlePart + lastPart;
        return id;
    }

    /**
     * Returns a String of the initials of the full name
     *
     * @return firstInitial + middlePart + lastInitial
     */
    public String getInitials() {
        String firstPart = first.toUpperCase();
        char middlePart = Character.toUpperCase(mid);
        String lastPart = last.toUpperCase();
        String firstInitial = firstPart.substring(0, 1);
        String lastInitial = lastPart.substring(0, 1);
        return firstInitial + middlePart + lastInitial;
    }

    /**
     * Returns the length of the full name
     *
     * @return length of the first name + length of the last name + 1
     */
    public int length() {
        return first.length() + last.length() + 1;
    }

    /**
     * Returns a String of the full name
     *
     * @return first mid. last
     */
    public String toString() {
        return first + " " + mid + ". " + last;
    }

    /**
     * Returns true if one name equals another
     *
     * @param o Object being compared
     * @return true or false
     */
    public boolean equals(Object o) {
        if(o instanceof Name) {
            Name n = (Name) o;
            return first.equals(n.getFirstName())
                    && mid == n.getMiddleInitial()
                    && last.equals(n.getLastName());
        } else {
            return false;
        }
    }
}