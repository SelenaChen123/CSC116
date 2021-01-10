import static org.junit.Assert.assertEquals;

import org.junit.*;
import junit.framework.TestCase;

/**
 * This program tests SomewhatMoreSimplifiedSolitaire
 * 
 * Somewhat Simplified Solitaire Encryption and Decryption algorithm.
 * 
 * See: https://www.schneier.com/academic/solitaire/
 * 
 * @author Dr. Jason King
 * @author Dr. Jessica Young Schmidt
 *
 */
public class SomewhatMoreSimplifiedSolitaireTest extends TestCase {
    @Test
    public void testEncrypt() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Encrypt the message \"HELLO\"";
        String expected = "TPVPR";
        String actual = SomewhatMoreSimplifiedSolitaire.encrypt(deck, "HELLO");
        assertEquals(description, expected, actual);
    }

    @Test
    public void testDecrypt() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Decrypt the message \"TPVPR\"";
        String expected = "HELLO";
        String actual = SomewhatMoreSimplifiedSolitaire.decrypt(deck, "TPVPR");
        assertEquals(description, expected, actual);
    }

    @Test
    public void testMoveFirstJokerDownByOne() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Moving Joker A down by one when Joker A "
                + "is not the last card in the deck";
        String expected = "1 4 7 10 13 3 6 9 12 15 2 14 5 8 11";
        String actual = SomewhatMoreSimplifiedSolitaire.moveFirstJokerDownOne(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 2 5 8 11 15 14";
        description = "Moving Joker A down by one when Joker A "
                + "is the last card in the deck";
        expected = "14 4 7 10 13 3 6 9 12 2 5 8 11 15 1";
        actual = SomewhatMoreSimplifiedSolitaire.moveFirstJokerDownOne(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testMoveSecondJokerDownByTwo() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Moving Joker B down by two when Joker B "
                + "is not one of the last two cards in the deck";
        String expected = "1 4 7 10 13 3 6 9 12 14 2 15 5 8 11";
        String actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 5 14 2 15 8 11";
        description = "Moving Joker B down by two when Joker B "
                + "is the third-to-last card in the deck";
        expected = "1 4 7 10 13 3 6 9 12 5 14 2 8 11 15";
        actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 8 14 2 5 15 11";
        description = "Moving Joker B down by two when Joker B "
                + "is not the last card in the deck";
        expected = "15 4 7 10 13 3 6 9 12 8 14 2 5 11 1";
        actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 11 14 2 5 8 15";
        description = "Moving Joker B down by two when Joker B "
                + "is the last card in the deck";
        expected = "4 15 7 10 13 3 6 9 12 11 14 2 5 8 1";
        actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testTripleCut() {
        String deck = "1 4 7 10 13 3 6 9 12 14 2 15 5 8 11";
        String description = "Triple cut with Joker A before Joker B";
        String expected = "5 8 11 14 2 15 1 4 7 10 13 3 6 9 12";
        String actual = SomewhatMoreSimplifiedSolitaire.tripleCut(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 2 5 8 11 15 14";
        description = "Triple cut with Joker B before Joker A";
        expected = "1 4 7 10 13 3 6 9 12 2 5 8 11 15 14";
        actual = SomewhatMoreSimplifiedSolitaire.tripleCut(deck);
        assertEquals(description, expected, actual);

    }

    @Test
    public void testMoveToBack() {
        String deck = "5 8 11 14 2 15 1 4 7 10 13 3 6 9 12";
        String description = "Moving a quantity of cards equal to the value "
                + "of the bottom card back to just before the bottom card "
                + "when the bottom card is not a Joker";
        String expected = "6 9 5 8 11 14 2 15 1 4 7 10 13 3 12";
        String actual = SomewhatMoreSimplifiedSolitaire.moveToBack(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 2 5 8 11 14 15";
        description = "Moving a quantity of cards equal to the value "
                + "of the bottom card back to just before the bottom card "
                + "when the bottom card is a Joker";
        expected = "1 4 7 10 13 3 6 9 12 2 5 8 11 14 15";
        actual = SomewhatMoreSimplifiedSolitaire.moveToBack(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testGetKey() {
        String deck = "6 9 5 8 11 14 2 15 1 4 7 10 13 3 12";
        String description = "Counting down the deck by a number of cards "
                + "equal to the value of the top card "
                + "and recording the value of the next card in the deck "
                + "when the top card is not a Joker";
        String expected = "2";
        String actual = SomewhatMoreSimplifiedSolitaire.getKey(deck);
        assertEquals(description, expected, actual);

        deck = "15 9 5 8 11 14 2 6 1 4 7 10 13 3 12";
        description = "Counting down the deck by a number of cards "
                + "equal to the value of the top card "
                + "and recording the value of the next card in the deck "
                + "when the top card is a Joker";
        expected = "12";
        actual = SomewhatMoreSimplifiedSolitaire.getKey(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testShuffle() {
        String deck = "15 14 1 4 7 10 13 3 6 9 12 2 5 8 11";
        String description = "Shuffling deck with Jokers at the beginning "
                + "and Joker B is in front of Joker A";
        String expected = "7 10 13 3 6 9 12 2 5 8 11 14 15 4 1";
        String actual = SomewhatMoreSimplifiedSolitaire.shuffle(deck);
        assertEquals(description, expected, actual);

        deck = "1 4 7 10 13 3 6 9 12 2 5 8 11 15 14";
        description = "Shuffling deck with Jokers at the end "
                + "and Joker B is in front of Joker A";
        expected = "15 4 7 10 13 3 6 9 12 2 5 8 11 1 14";
        actual = SomewhatMoreSimplifiedSolitaire.shuffle(deck);
        assertEquals(description, expected, actual);
    }

}
