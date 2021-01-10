import org.junit.*;
import junit.framework.TestCase;

/*
 * Program to test Event class
 *
 * @author Selena Chen
 * @author Joseph Dasilva
 * @author Sarah Peterson
 */
 public class EventTest extends TestCase {
 	public static final Event firstEvent = new Event(900, 930, "Breakfast", "Eat breakfast");
 	
 	public static final Event secondEvent = new Event(1200, 1230, "Lunch", "Eat lunch");
 	
 	@Test
 	public void testGetStartingTime() {
 		assertTrue(firstEvent.getStartingTime() == 900);
 	}
 	
 	@Test
 	public void testGetEndingTime() {
 		assertTrue(firstEvent.getEndingTime() == 930);
 	}
 	
 	@Test
 	public void testGetTitle() {
 		assertTrue(firstEvent.getTitle().equals("Breakfast"));
 	}
 	
 	@Test
 	public void testGetDescription() {
 		assertTrue(firstEvent.getDescription().equals("Eat breakfast"));
 	}
 	
 	@Test
 	public void testIsConflict1() {
 		assertTrue(firstEvent.isConflict(firstEvent));
 	}
 	
 	@Test
 	public void testIsConflict2() {
 		assertFalse(firstEvent.isConflict(secondEvent));
 	}
 	
 	@Test
 	public void testToString() {
 		String actual = "900 - 930" + "\n" + "Breakfast" + "\n" + "Eat breakfast" + "\n";
 		assertEquals(firstEvent.toString(), actual);
 	}
 	
 	@Test
 	public void testEquals1() {
 		assertTrue(firstEvent.equals(new Event(900, 930, "Breakfast", "Eat breakfast")));
 	}
 	
 	@Test
 	public void testEquals2() {
 		assertFalse(firstEvent.equals(secondEvent));
 	}
 }