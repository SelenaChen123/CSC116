import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test Reminder methods
 * @author Sarah Peterson
 * @author Joseph Dasilva
 * @author Selena Chen
 */
public class ReminderTest extends TestCase {

    /** Lunch Reminder for testing */
    private Reminder lunch;
    
    
    @Before
    public void setUp() {
        lunch = new Reminder(1200, "Lunch", "Eat lunch");
    }
    
    @Test
    public void testGetTime() {
        assertEquals("Lunch time", 1200, lunch.getTime());
    }
    
    @Test
    public void testGetTitle() {
        assertEquals("Lunch title", "Lunch", lunch.getTitle());
    }
    
    @Test
    public void testGetDescription() {
        assertEquals("Lunch description", "Eat lunch", lunch.getDescription());
    }
    
    @Test
    public void testToString() {
        String lunchString = "1200\nLunch\nEat lunch\n";
        assertEquals("Lunch String", lunchString, lunch.toString());
    }
    
    @Test
    public void testEquals() {
        assertTrue("Lunch equals with same instance", lunch.equals(lunch));
        assertTrue("Lunch equals with different instances", lunch.equals(new Reminder(1200, "Lunch", "Eat lunch")));
        assertFalse("Lunch with different Reminder", lunch.equals(new Reminder(1400, "Meeting", "Meeting with boss")));
    }
}