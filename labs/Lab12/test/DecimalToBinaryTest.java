import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalToBinaryTest {

    @Test
    public void testConvertToBinaryValid() {
        // Zero - special case
        String id = "Zero";
        String desc = "DecimalToBinary.convertToBinary(0)";
        String expected = "0";
        String actual = DecimalToBinary.convertToBinary(0);
        assertEquals(id, expected, actual);

    }

    @Test
    public void testConvertToBinaryInvalid() {
        try {
            DecimalToBinary.convertToBinary(-1);
            fail("-1");
        } catch (IllegalArgumentException e) {
            assertEquals("-1", "Negative value: -1", e.getMessage());
        }

        try {
            DecimalToBinary.convertToBinary(-2468);
            fail("-2468");
        } catch (IllegalArgumentException e) {
            assertEquals("-2468", "Negative value: -2468", e.getMessage());
        }
    }
    
    @Test
    public void testConvertToBinaryEquals1() {
        String descr = "Testing converting decimal 44 to binary";
        String expected = "101100";
        String actual = DecimalToBinary.convertToBinary(44);
        assertEquals(descr, expected, actual);
    }
    
    @Test
    public void testConvertToBinaryEquals2() {
    	String descr = "Testing converting decimal 1048576 to binary";
		String expected = "100000000000000000000";
		String actual = DecimalToBinary.convertToBinary(1048576);
		assertEquals(descr, expected, actual);
    }
    
    @Test
    public void testConvertToBinaryEquals3() {
    	String descr = "Testing 0";
		String expected = "0";
		String actual = DecimalToBinary.convertToBinary(0);
		assertEquals(descr, expected, actual);
    }
    
    @Test
    public void testConvertToBinaryEquals4() {
    	String descr = "Testing 1";
		String expected = "1";
		String actual = DecimalToBinary.convertToBinary(1);
		assertEquals(descr, expected, actual);
    }
}
