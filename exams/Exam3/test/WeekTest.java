import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.*;

/**
 * Tests Week class
 * @author Joseph Dasilva
 * @author Selena Chen
 * @author Sarah Peterson
 */
 public class WeekTest extends TestCase {
 
    /** Week used in testing */
    private Week week;
    /** Array of days in the week used in testing */
    private Day[] days;
    /** Monday used in array of days for testing */
    private Day monday;
    /** Tjuesday used in array of days for testing */
    private Day tuesday;
    /** Wednesday used in array of days for testing */
    private Day wednesday;
    /** Thursday used in array of days for testing */
    private Day thursday;
    /** Friday used in array of days for testing */
    private Day friday;
    
    @Before
    public void setUp() {
        monday = new Day("monday");
        tuesday = new Day("tuesday");
        wednesday = new Day("wednesday");
        thursday = new Day("thursday");
        friday = new Day("friday");
        days = new Day[5];
        days[0] = monday;
        days[1] = tuesday;
        days[2] = wednesday;
        days[3] = thursday;
        days[4] = friday;
        week = new Week(days);
    }
    
    @Test
    public void testGetDays() {
        assertEquals("Getting days", days, week.getDays());
    }
    
    @Test
    public void testGetSpecificDay() {
        assertEquals("Get monday", monday, week.getSpecificDay(0));
        assertEquals("Get tuesday", tuesday, week.getSpecificDay(1));
        assertEquals("Get wednesday", wednesday, week.getSpecificDay(2));
        assertEquals("Get thursday", thursday, week.getSpecificDay(3));
        assertEquals("Get friday", friday, week.getSpecificDay(4));
    }
 }