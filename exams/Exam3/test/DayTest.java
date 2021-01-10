import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.*;

/**
 * Tests the Day class
 * @author Sarah Peterson
 * @author Joseph Dasilva
 * @author Selena Chen
 */
 public class DayTest extends TestCase {
    
    /** Day used in testing */
    private Day monday;
    /** Event added to the day to use in testing */
    private Event meeting;
    /** Reminder added to the day to use in testing */
    private Reminder lunch;
    /** ArrayList of events used to test Events in Day */
    private ArrayList<Event> mondayEvents = new ArrayList();
    /** ArrayList of reminders to test Reminders in day */
    private ArrayList<Reminder> mondayReminders = new ArrayList();
    
    @Before
    public void setUp() {
        monday = new Day("monday");
        meeting = new Event(1000, 1100, "Meeting", "Meeting with boss");
        lunch = new Reminder(1200, "Lunch", "Eat lunch");
        monday.addEventToDay(meeting);
        monday.addReminderToDay(lunch);
        mondayEvents.add(meeting);
        mondayReminders.add(lunch);
    }
    
    @Test
    public void testGetDayName() {
        assertEquals("Monday name", "monday", monday.getDayName());
    }
    
    @Test
    public void testGetEvents() {
        assertEquals("Getting Events", mondayEvents, monday.getEvents());
    }
    
    @Test
    public void testGetReminders() {
        assertEquals("Getting Reminders", mondayReminders, monday.getReminders());
    }
 }