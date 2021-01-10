import java.util.Scanner;

import org.junit.Test;
import junit.framework.TestCase;

//TODO: Add javadoc
public class WeatherReporterTest extends TestCase {

    @Test
    public void testProcessLine() {
        String input = "20100627    85.4    100.9   73  000000";
        String description = "Temperature over 100";
        String expected = "06/27/2010 Low:  73.0 High: 100.9 Rain:  no Snow:  no";
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testProcessLine2() {
        String input = "20100628    30.4    34.9   13  010000";
        String description = "Raining";
        String expected = "06/28/2010 Low:  13.0 High:  34.9 Rain: yes Snow:  no";
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }
    
    @Test
    public void testProcessLine3() {
        String input = "20100629    30.4    34.9   13  001000";
        String description = "Snowing";
        String expected = "06/29/2010 Low:  13.0 High:  34.9 Rain:  no Snow: yes";
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }
}
