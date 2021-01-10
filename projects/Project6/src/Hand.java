import java.util.*;

/** 
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Selena Chen
 */
public class Hand {
    /** The number of cards a Hand holds in their hand at a time */
    public static final int CARDS_IN_HAND = 5;

    /** Contains cards in hand */
    private Card[] hand;
    
    /**
     * Creates the array of cards to be used as the hand
     * 
     * @param hand array of Card objects to be used as the hand
     */
    public Hand(Card[] hand) {
        if(hand == null) {
            throw new NullPointerException("Null array");
        }
        if(hand.length != CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid array length");
        }
        boolean isNull = false;
        for(int handIndex = 0; handIndex < hand.length; handIndex++) {
            if(hand[handIndex] == null) {
                isNull = true;
            }
        }
        if(isNull) {
            throw new NullPointerException("Null element");
        }
        this.hand = hand;
    }
    
    /**
     * Getter method for the hand array
     *
     * @return hand hand array
     */
    public Card[] getHand() {
        return hand;
    }
    
    /**
     * Returns the card from the hand array at the index specified by the parameter
     * 
     * @param index index specified
     * @return card card at the index specified
     */
    public Card getCard(int index) {
        if(index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        Card card = hand[index];
        return card;
    }
    
    /**
     * Replaces the card at the given index in the hand array with the card passed to the method
     * 
     * @param index given index
     * @param card Card object being replaced
     */
    public void replace(int index, Card card) {
        if(index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        if(card == null) {
            throw new NullPointerException("Null card");
        }
        hand[index] = card;
    }
    
    /**
     * Returns a String representation of the hand
     *
     * @return handString String representation of the hand
     */
    public String toString() {
        String handString = "[";
        for(int handIndex = 0; handIndex < CARDS_IN_HAND; handIndex++) {
            handString = handString + hand[handIndex];
            if(handIndex != CARDS_IN_HAND - 1) {
                handString += ", ";
            }
        }
        handString += "]";
        return handString;
    }
    
    /**
     * Returns whether this hand and o are equal
     * 
     * @param o Object being compared to
     * @return true or false
     */
    public boolean equals(Object o) {
        if (o instanceof Hand) {
            Hand other = (Hand) o;
            return (Arrays.equals(getSortedHand(), other.getSortedHand()));
        } else {
            return false;
        }
    }

    /**
     * Counts the number of cards with each value in the hand
     *
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     *
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }
    
    /**
     * Checks whether all the cards in the hand have the same suit
     *
     * @return true or false
     */
    public boolean isFlush() {
        char suit = hand[0].getSuit();
        for(int handIndex = 1; handIndex < CARDS_IN_HAND; handIndex++) {
            if(hand[handIndex].getSuit() != suit) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks whether the values of the cards in the hand are in sequence
     *
     * @return true or false
     */
    public boolean isStraight() {
        Card[] sortedHand = getSortedHand();
        int value = sortedHand[0].getValue();
        for(int handIndex = 1; handIndex < CARDS_IN_HAND; handIndex++) {
            if(sortedHand[handIndex].getValue() != value + 1) {
                return false;
            }
            value++;
        }
        return true;
    }
    
    /**
     * Checks whether the cards in the hand have the same suit and are in sequence
     *
     * @return true or false
     */
    public boolean isStraightFlush() {
        if(isStraight() && isFlush()) {
            return true;
        }
        return false;
    }
    
    /**
     * Checks whether the cards in the hand have the same suit and the values 10, 11, 12, 13, 14
     *
     * @return true or false
     */
    public boolean isRoyalFlush() {
        if(isStraight() && isFlush()) {
            Card[] sortedHand = getSortedHand();
            int value = 10;
            for(int handIndex = 0; handIndex < CARDS_IN_HAND; handIndex++) {
                if(sortedHand[handIndex].getValue() != value) {
                    return false;
                }
                value++;
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Checks whether the hand has four cards with the same value
     *
     * @return true or false
     */
    public boolean hasFourOfAKind() {
        Card[] sortedHand = getSortedHand();
        if(sortedHand[0].getValue() != sortedHand[CARDS_IN_HAND - 1].getValue()
            && sortedHand[0].getValue() == sortedHand[1].getValue()
            && sortedHand[0].getValue() == sortedHand[2].getValue()
            && sortedHand[0].getValue() == sortedHand[3].getValue()) {
            return true;
        } else {
            return (sortedHand[0].getValue() != sortedHand[CARDS_IN_HAND - 1].getValue()
                    && sortedHand[1].getValue() == sortedHand[2].getValue()
                    && sortedHand[1].getValue() == sortedHand[3].getValue()
                    && sortedHand[1].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue());
        }
    }
    
    /**
     * Checks whether the hand has exactly three cards with the same value
     *
     * @return true or false
     */
    public boolean hasThreeOfAKind() {
        Card[] sortedHand = getSortedHand();
        if(hasFourOfAKind() == false && sortedHand[0].getValue()
            != sortedHand[CARDS_IN_HAND - 1].getValue()
            && sortedHand[0].getValue() == sortedHand[1].getValue()
            && sortedHand[0].getValue() == sortedHand[2].getValue()) {
            return true;
        } else if(hasFourOfAKind() == false && sortedHand[0].getValue()
                    != sortedHand[CARDS_IN_HAND - 1].getValue()
                    && sortedHand[1].getValue() == sortedHand[2].getValue()
                    && sortedHand[1].getValue() == sortedHand[3].getValue()) {
            return true;
        } else {
            return (hasFourOfAKind() == false && sortedHand[0].getValue()
                    != sortedHand[CARDS_IN_HAND - 1].getValue()
                    && sortedHand[2].getValue() == sortedHand[3].getValue()
                    && sortedHand[2].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue());
        }
    }
    
    /**
     * Checks whether the hand has exactly two pairs
     *
     * @return true or false
     */
    public boolean hasTwoPairs() {
        Card[] sortedHand = getSortedHand();
        if(hasFourOfAKind() == false && hasThreeOfAKind() == false
            && sortedHand[0].getValue() != sortedHand[CARDS_IN_HAND - 1].getValue()
            && sortedHand[0].getValue() == sortedHand[1].getValue()) {
            return (sortedHand[2].getValue() == sortedHand[3].getValue()
                    || sortedHand[3].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue());
        } else {
            return (hasFourOfAKind() == false && hasThreeOfAKind() == false
                    && sortedHand[0].getValue() != sortedHand[CARDS_IN_HAND - 1].getValue()
                    && sortedHand[1].getValue() == sortedHand[2].getValue()
                    && sortedHand[3].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue());
        }
    }
    
    /**
     * Checks whether the hand contains exactly one pair
     *
     * @return true or false
     */
    public boolean hasOnePair() {
        Card[] sortedHand = getSortedHand();
        if(hasFourOfAKind() == false && hasThreeOfAKind() == false && hasTwoPairs() == false
            && sortedHand[0].getValue() != sortedHand[CARDS_IN_HAND - 1].getValue()) {
            return (sortedHand[0].getValue() == sortedHand[1].getValue()
                    || sortedHand[1].getValue() == sortedHand[2].getValue()
                    || sortedHand[2].getValue() == sortedHand[3].getValue()
                    || sortedHand[3].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue());
        } else {
            return false;
        }
    }
    
    /**
     * Checks whether the hand contains three cards with the same value and two other cards with
     * the same value, but different from that of the three cards
     *
     * @return true or false
     */
    public boolean isFullHouse() {
        Card[] sortedHand = getSortedHand();
        if(sortedHand[0].getValue() != sortedHand[CARDS_IN_HAND - 1].getValue()
            && hasThreeOfAKind() == true) {
            if(sortedHand[0].getValue() == sortedHand[1].getValue()
                && sortedHand[0].getValue() == sortedHand[2].getValue()) {
                return (sortedHand[3].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue());
            } else if(sortedHand[2].getValue() == sortedHand[3].getValue()
                        && sortedHand[2].getValue() == sortedHand[CARDS_IN_HAND - 1].getValue()) {
                return (sortedHand[0].getValue() == sortedHand[1].getValue());
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}