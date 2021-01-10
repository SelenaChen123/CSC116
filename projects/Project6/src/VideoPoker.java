/**
 * Handles the logic behind a game of Video Poker
 * 
 * @author Selena Chen
 */
public class VideoPoker {
    /** Indicates that a random game should be played */
    public static final int RANDOM_GAME = -1;
    /** The number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;
    /** The number of points that the player has when the game begins */
    public static final int STARTING_POINTS = 100;
    /** The number of points needed to play a new game */
    public static final int POINTS_FOR_NEW_GAME = 10;
    /** The number of points awarded for a Royal Flush, set to 100 */
    public static final int ROYAL_FLUSH = 100;
    /** The number of points awarded for a Straight Flush */
    public static final int STRAIGHT_FLUSH = 60;
    /** The number of points awarded for Four of a Kind */
    public static final int FOUR_OF_A_KIND = 50;
    /** The number of points awarded for a Full House */
    public static final int FULL_HOUSE = 40;
    /** The number of points awarded for a Flush */
    public static final int FLUSH = 30;
    /** The number of points awarded for a Straight */
    public static final int STRAIGHT = 25;
    /** The number of points awarded for Three of a Kind */
    public static final int THREE_OF_A_KIND = 15;
    /** The number of points awarded for Two Pairs */
    public static final int TWO_PAIRS = 10;
    /** The number of points awarded for One Pair */
    public static final int ONE_PAIR = 7;
    
    /** Deck of cards that will be used to play the game */
    private Deck deck;
    /** Hand of Cards in the game */
    private Hand hand;
    /** Current number of points */
    private int points;
    
    /**
     * Creates a deck using the seed
     * 
     * @param seed random seed
     */
    public VideoPoker(int seed) {
        points = STARTING_POINTS;
        deck = new Deck(seed);
    }
    
    /**
     * Returns the number of points
     * 
     * @return points number of points
     */
    public int getPoints() {
        return points;
    }
    
    /**
     * Returns the name of the image file for the Card at the given index in the hand
     * 
     * @param index given index
     * @return image name of the image file for the card at the given index
     */
    public String getCardFileName(int index) {
        String image = "cards/" + hand.getCard(index).toString() + ".gif";
        return image;
    }
    
    /**
     * Returns the card at the given index in the hand
     * 
     * @param index given index
     * @return card card at the given index in the hand
     */
    public Card getCard(int index) {
        Card card = hand.getCard(index);
        return card;
    }
    
    /**
     * Subtracts POINTS_FOR_NEW_GAME from points and shuffles the deck
     */
    public void newGame() {
        points -= POINTS_FOR_NEW_GAME;
        deck.shuffle();
        Card[] newHand = new Card[CARDS_IN_HAND];
        for(int handIndex = 0; handIndex < CARDS_IN_HAND; handIndex++) {
            newHand[handIndex] = new Card(2, 'c');
        }
        hand = new Hand(newHand);
        for(int handIndex = 0; handIndex < CARDS_IN_HAND; handIndex++) {
            hand.replace(handIndex, deck.nextCard());
        }
    }
    
    /**
     * Gets the next Card from the deck and requests the hand to replace the card at the given
     * index with the new Card
     * 
     * @param index given index
     */
    public void replaceCard(int index) {
        hand.replace(index, deck.nextCard());
    }
    
    /**
     * Returns a String with the type of hand and adds the correct number of points to the total
     * points based on the type of hand
     * 
     * @return handType String with the type of hand
     */
    public String scoreHand() {
        String handType = "";
        if(hand.isRoyalFlush()) {
            handType = "Royal Flush";
            points += ROYAL_FLUSH;
        } else if(hand.isStraightFlush()) {
            handType = "Straight Flush";
            points += STRAIGHT_FLUSH;
        } else if(hand.hasFourOfAKind()) {
            handType = "Four of a Kind";
            points += FOUR_OF_A_KIND;
        } else if(hand.isFullHouse()) {
            handType = "Full House";
            points += FULL_HOUSE;
        } else if(hand.isFlush()) {
            handType = "Flush";
            points += FLUSH;
        } else if(hand.isStraight()) {
            handType = "Straight";
            points += STRAIGHT;
        } else if(hand.hasThreeOfAKind()) {
            handType = "Three of a Kind";
            points += THREE_OF_A_KIND;
        } else if(hand.hasTwoPairs()) {
            handType = "Two Pairs";
            points += TWO_PAIRS;
        } else if(hand.hasOnePair()) {
            handType = "One Pair";
            points += ONE_PAIR;
        } else {
            handType = "No Pair";
        }
        return handType;
    }
}