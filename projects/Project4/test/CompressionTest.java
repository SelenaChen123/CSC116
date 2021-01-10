import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test Compression methods
 * @author Suzanne Balik
 * @author
 */
public class CompressionTest extends TestCase {

    /** single word with two "re"'s and one "ing" character sequence */
    public static final String WORD1 = "regretting";

    /** single word with one of two "re"'s and one "ing" replaced by characters */
    public static final String WORD1_COMPRESSED = "$grett@";
    
    /** single word with one "the" and one "re" character sequence */
    public static final String WORD2 = "there";

    /** single word with one "the" and one "re" replaced by characters */
    public static final String WORD2_COMPRESSED = "&$";
    
    /** single word with two "ion" character sequences */
    public static final String WORD3 = "rationalization";

    /** single word with one of two "ion"'s replaced by characters */
    public static final String WORD3_COMPRESSED = "rat#alization";
    
    /** single word with one "an" character sequence */
    public static final String WORD4 = "an";

    /** single word with one "an" replaced by characters */
    public static final String WORD4_COMPRESSED = "~";
    
    /** single word with one "an" and one "tis" character sequence */
    public static final String WORD5 = "mantis";

    /** single word with one "tis" replaced by characters */
    public static final String WORD5_COMPRESSED = "m~%";
    
    /** single word with one "men", one "ion", and one "ing" character sequence */
    public static final String WORD6 = "mentioning";

    /** single word with one one "men", one "ion", and one "ing" replaced by characters */
    public static final String WORD6_COMPRESSED = "+t#@";

    /** first multiword line with multiple character sequences */
    public static final String LINE1 = "the action had an equal and opposite reaction.";
    
    /** first multiword line with multiple replacement characters */
    public static final String LINE1_COMPRESSED = "& act# had ~ equal ~d opposite $act#.";
    
    /** second multiword line with multiple character sequences */
    public static final String LINE2 = "there were many automatic computing devices";
    
    /** second multiword line with multiple replacement characters */
    public static final String LINE2_COMPRESSED = "&$ we$ m~y automatic comput@ devices";
    
    /** third multiword line with multiple character sequences */
    public static final String LINE3 = "the praying mantis is praying";
    
    /** third multiword line with multiple replacement characters */
    public static final String LINE3_COMPRESSED = "& pray@ m~% is pray@";
    
    /** fourth multiword line with multiple character sequences */
    public static final String LINE4 = "the world war spurred the development of electronics";
    
    /** fourth multiword line with multiple replacement characters */
    public static final String LINE4_COMPRESSED = "& world war spur$d & develop+t of electronics";
    
    /** fifth multiword line with no character sequences */
    public static final String LINE5 = "components started to become available";
    
    /** fifth multiword line with no replacement characters */
    public static final String LINE5_COMPRESSED = "components started to become available";
    
    /** sixth multiword line with one character sequence */
    public static final String LINE6 = "the quick brown fox jumps over a lazy dog";
    
    /** sixth multiword line with one replacement sequence */
    public static final String LINE6_COMPRESSED = "& quick brown fox jumps over a lazy dog";


    @Test
    public void testCompressWord1() {
        String description = "Compress Word 1";
        String actual = Compression.compressWord(WORD1);
        assertEquals(description, WORD1_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressWord2() {
        String description = "Compress Word 2";
        String actual = Compression.compressWord(WORD2);
        assertEquals(description, WORD2_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressWord3() {
        String description = "Compress Word 3";
        String actual = Compression.compressWord(WORD3);
        assertEquals(description, WORD3_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressWord4() {
        String description = "Compress Word 4";
        String actual = Compression.compressWord(WORD4);
        assertEquals(description, WORD4_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressWord5() {
        String description = "Compress Word 5";
        String actual = Compression.compressWord(WORD5);
        assertEquals(description, WORD5_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressWord6() {
        String description = "Compress Word 6";
        String actual = Compression.compressWord(WORD6);
        assertEquals(description, WORD6_COMPRESSED, actual);
    }

    @Test
    public void testDecompressWord1() {
        String description = "Decompress Word 1";
        String actual = Compression.decompressWord(WORD1_COMPRESSED);
        assertEquals(description, WORD1, actual);
    }
    
    @Test
    public void testDecompressWord2() {
        String description = "Decompress Word 2";
        String actual = Compression.decompressWord(WORD2_COMPRESSED);
        assertEquals(description, WORD2, actual);
    }
    
    @Test
    public void testDecompressWord3() {
        String description = "Decompress Word 3";
        String actual = Compression.decompressWord(WORD3_COMPRESSED);
        assertEquals(description, WORD3, actual);
    }
    
    @Test
    public void testDecompressWord4() {
        String description = "Decompress Word 4";
        String actual = Compression.decompressWord(WORD4_COMPRESSED);
        assertEquals(description, WORD4, actual);
    }
    
    @Test
    public void testDecompressWord5() {
        String description = "Decompress Word 5";
        String actual = Compression.decompressWord(WORD5_COMPRESSED);
        assertEquals(description, WORD5, actual);
    }
    
    @Test
    public void testDecompressWord6() {
        String description = "Decompress Word 6";
        String actual = Compression.decompressWord(WORD6_COMPRESSED);
        assertEquals(description, WORD6, actual);
    }
    
    
    @Test
    public void testCompressLine1() {
        String description = "Compress Line 1";
        String actual = Compression.compressLine(LINE1);
        assertEquals(description, LINE1_COMPRESSED, actual);
    }

    @Test
    public void testCompressLine2() {
        String description = "Compress Line 2";
        String actual = Compression.compressLine(LINE2);
        assertEquals(description, LINE2_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressLine3() {
        String description = "Compress Line 3";
        String actual = Compression.compressLine(LINE3);
        assertEquals(description, LINE3_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressLine4() {
        String description = "Compress Line 4";
        String actual = Compression.compressLine(LINE4);
        assertEquals(description, LINE4_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressLine5() {
        String description = "Compress Line 5";
        String actual = Compression.compressLine(LINE5);
        assertEquals(description, LINE5_COMPRESSED, actual);
    }
    
    @Test
    public void testCompressLine6() {
        String description = "Compress Line 6";
        String actual = Compression.compressLine(LINE6);
        assertEquals(description, LINE6_COMPRESSED, actual);
    }

    @Test
    public void testDecompressLine1() {
        String description = "Decompress Line 1";
        String actual = Compression.decompressLine(LINE1_COMPRESSED);
        assertEquals(description, LINE1, actual);
    }
    
    @Test
    public void testDecompressLine2() {
        String description = "Decompress Line 2";
        String actual = Compression.decompressLine(LINE2_COMPRESSED);
        assertEquals(description, LINE2, actual);
    }
    
    @Test
    public void testDecompressLine3() {
        String description = "Decompress Line 3";
        String actual = Compression.decompressLine(LINE3_COMPRESSED);
        assertEquals(description, LINE3, actual);
    }
    
    @Test
    public void testDecompressLine4() {
        String description = "Decompress Line 4";
        String actual = Compression.decompressLine(LINE4_COMPRESSED);
        assertEquals(description, LINE4, actual);
    }
    
    @Test
    public void testDecompressLine5() {
        String description = "Decompress Line 5";
        String actual = Compression.decompressLine(LINE5_COMPRESSED);
        assertEquals(description, LINE5, actual);
    }
    
    @Test
    public void testDecompressLine6() {
        String description = "Decompress Line 6";
        String actual = Compression.decompressLine(LINE6_COMPRESSED);
        assertEquals(description, LINE6, actual);
    }
}
