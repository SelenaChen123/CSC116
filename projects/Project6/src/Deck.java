import java.util.Random;
import java.util.Arrays;

/**
 * Represents a deck of 52 playing cards
 * 
 * @author Selena Chen
 */
public class Deck {
    /** The number of cards in the deck */
    public static final int CARDS_IN_DECK = 52;
    
    /** Card objects that will be used to manage the CARDS_IN_DECK cards in the deck */
    private Card[] cards;
    /** Index of the next card to be dealt from the array of Cards */
    private int nextCardIndex;
    /** Maintains the random seed provided for testing */
    private int seed;
    
    /** Constant integer to represent the clubs suit */
    private static final int CLUBS = 1;
    /** Constant integer to represent the diamonds suit */
    private static final int DIAMONDS = 2;
    /** Constant integer to represent the hearts suit */
    private static final int HEARTS = 3;
    /** Constant integer to represent the spades suit */
    private static final int SPADES = 4;
    
    /**
     * Creates the deck of cards using Card objects and a seed
     * 
     * @param seed random seed
     */
    public Deck(int seed) {
        this.seed = seed;
        cards = new Card[CARDS_IN_DECK];
        int count = 0;
        for(int suit = CLUBS; suit <= SPADES; suit++) {
            for(int cardValue = Card.LOWEST_VALUE; cardValue <= Card.HIGHEST_VALUE; cardValue++) {
                if(count < CARDS_IN_DECK) {
                    char suitLetter = 'a';
                    if(suit == CLUBS) {
                        suitLetter = Card.CLUBS;
                    } else if(suit == DIAMONDS) {
                        suitLetter = Card.DIAMONDS;
                    } else if(suit == HEARTS) {
                        suitLetter = Card.HEARTS;
                    } else {
                        suitLetter = Card.SPADES;
                    }
                    cards[count] = new Card(cardValue, suitLetter);
                    count++;
                }
            }
        }
        nextCardIndex = 0;
    }
    
    /**
     * Getter method for the cards array
     *
     * @return cards cards array
     */
    public Card[] getCards() {
        return cards;
    }
    
    /**
     * Getter method for the index of the next card in the deck
     *
     * @return nextCardIndex index of the next card in the deck
     */
    public int getNextCardIndex() {
        return nextCardIndex;
    }
    
    /**
     * Getter method for the seed
     *
     * @return seed random seed
     */
    public int getSeed() {
        return seed;
    }
    
    /**
     * Handles resetting the deck for a new hand to be played
     */
    public void shuffle() {
        Random rand = null;
        if(seed == -1) {
            rand = new Random();
        } else {
            rand = new Random(seed);
        }
        for(nextCardIndex = CARDS_IN_DECK - 1; nextCardIndex > 0; nextCardIndex--) {
            int random = rand.nextInt(nextCardIndex + 1);
            Card temp = cards[nextCardIndex];
            cards[nextCardIndex] = cards[random];
            cards[random] = temp;
        }
        nextCardIndex = 0;
    }
    
    /**
     * Returns the next card in the deck based on the instance field that knows the position within
     * the array where the next card to be dealt is located
     * 
     * @return next next card in the deck
     */
    public Card nextCard() {
        Card next = cards[nextCardIndex];
        nextCardIndex++;
        return next;
    }
    
    /**
     * Returns whether this deck and o are equal
     * 
     * @param o Object being compared to
     * @return true or false
     */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck other = (Deck) o;
            return (Arrays.equals(cards, other.getCards())
                    && nextCardIndex == other.getNextCardIndex()
                    && seed == other.getSeed());
        } else {
            return false;
        }
    }
    
    /**
     * Returns a String representation of the deck
     *
     * @return deck String representation of the deck
     */
    public String toString() {
        String deck = "";
        for(nextCardIndex = 0; nextCardIndex < CARDS_IN_DECK; nextCardIndex++) {
            deck = deck + "card " + nextCardIndex + ": " + cards[nextCardIndex].toString() + "\n";
        }
        return deck;
    }
}