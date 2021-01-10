import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Program to test RalphiesTopSecretCode
 * 
 * @author Jessica Young Schmidt
 */
public class RalphiesTopSecretCodeTest {

    @Test
    public void testTranslateApple() {
        String id = "a-p-e";
        String desc = "translate(\"apple\")";
        String expected = "felppa";
        String actual = RalphiesTopSecretCode.translate("apple");
        assertEquals(desc, expected, actual);

    }

    @Test
    public void testTranslateUncle() {
        String id = "uncle";
        String desc = "translate(\"uncle\")";
        String expected = "felcnu";
        String actual = RalphiesTopSecretCode.translate("uncle");
        assertEquals(desc, expected, actual);
    }

    @Test
    public void testTranslateLocal() {

        String id = "local";
        String desc = "translate(\"local\")";
        String expected = "klolac";
        String actual = RalphiesTopSecretCode.translate("local");
        assertEquals(desc, expected, actual);
    }

    @Test
    public void testTranslateWolfpack() {
        String id = "w-k";
        String desc = "translate(\"wolfpack\")";
        String expected = "kcapflow";
        String actual = RalphiesTopSecretCode.translate("wolfpack");
        assertEquals(desc, expected, actual);
    }

    @Test
    public void testTranslateYellow() {
        String id = "*-l-*";
        String desc = "translate(\"*yellow*\")";
        String expected = "*yellow*";
        String actual = RalphiesTopSecretCode.translate("*yellow*");
        assertEquals(desc, expected, actual);

    }

    @Test
    public void testTranslateDog() {

        String id = "dog";
        String desc = "translate(\"dog\")";
        String expected = "god";
        String actual = RalphiesTopSecretCode.translate("dog");
        assertEquals(desc, expected, actual);
    }

    @Test
    public void testTranslateInvalid() {

        String id = "\"\"";
        String desc = "translate(\"\")";
        String expected = "IllegalArgumentException";
        String actual = "";
        try {
            actual = RalphiesTopSecretCode.translate("");
        } catch (IllegalArgumentException e) {
            actual = "IllegalArgumentException";
        }
        assertEquals(desc, expected, actual);
    }

}
