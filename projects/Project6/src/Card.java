/**
 * Represents a single playing card used in the Video Poker game
 * 
 * @author Selena Chen
 */
public class Card implements Comparable<Card> {
    /** A char value that represents the suit “Clubs.” */
    public static final char CLUBS = 'c';
    /** A char value that represents the suit “Diamonds.” */
    public static final char DIAMONDS = 'd';
    /** A char value that represents the suit “Spades.” */
    public static final char SPADES = 's';
    /** A char value that represents the suit “Hearts.” */
    public static final char HEARTS = 'h';
    /** The lowest numeric value for a card. */
    public static final int LOWEST_VALUE = 2;
    /** The highest numeric value for a card. */
    public static final int HIGHEST_VALUE = 14;
    
    /** Value shown on the card */
    private int value;
    /** Suit shown on the card */
    private char suit;

    /**
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     * 
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
    
    /**
     * Accepts a value and a suit to assign to the instance fields
     * 
     * @param value value shown on the card
     * @param suit suit shown on the card
     */
    public Card(int value, char suit) {
        if(value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        if(suit != 'c' && suit != 'd' && suit != 'h' && suit != 's') {
            throw new IllegalArgumentException("Invalid suit");
        }
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * Getter method for the instance field that knows the value of the card
     * 
     * @return value value of the card
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Getter method for the instance field that knows the suit of the card
     * 
     * @return suit suit of the card
     */
    public char getSuit() {
        return suit;
    }
    
    /**
     * Returns whether this card and o are equal
     * 
     * @param o Object being compared to
     * @return true or false
     */
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card other = (Card) o;
            return (value == other.getValue() && suit == other.getSuit());
        } else {
            return false;
        }
    }
    
    /**
     * Returns the first letter of the suit (lowercase) followed by the numeric value of the card
     *
     * @return card suit and value of the card
     */
    public String toString() {
        String card = "" + suit + value;
        return card;
    }
}