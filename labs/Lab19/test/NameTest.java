import org.junit.Test;

import junit.framework.TestCase;

//TODO: Javadoc
public class NameTest extends TestCase {

    @Test
    public void testAllMethods() {
        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();
        Name name4 = new Name();
        Name name5 = new Name();
        name1.setFirstName("Alice");
        name2.setFirstName("Alice");
        name3.setFirstName("Alice");
        name4.setFirstName("Bob");
        name5.setFirstName("Alice");
        name1.setLastName("Smith");
        name2.setLastName("Smith");
        name3.setLastName("Smit");
        name4.setLastName("Doe");
        name5.setLastName("Smith");
        name1.setMiddle('A');
        name2.setMiddle('A');
        name3.setMiddle('A');
        name4.setMiddle('A');
        name5.setMiddle('B');
        assertEquals("Normal order Alice", "Alice A. Smith", name1.getNormalOrder());
        assertEquals("Reverse order Alice", "Smith, Alice A.", name1.getReverseOrder());
        assertEquals("toString Alice", "Alice A. Smith", name1.toString());
        assertEquals("Normal order Bob", "Bob A. Doe", name4.getNormalOrder());
        assertEquals("Reverse order Bob", "Doe, Bob A.", name4.getReverseOrder());
        assertEquals("toString Bob", "Bob A. Doe", name4.toString());
        assertTrue("Same object - equals", name1.equals(name1));
        assertTrue("Same name - equals", name1.equals(name2));
        assertTrue("Same name  - equals", name2.equals(name1));
        assertFalse("Different last name equals", name1.equals(name3));
        assertFalse("Different last name equals", name3.equals(name1));
        assertFalse("Different middle initials equals", name1.equals(name5));
        assertFalse("Different names - equals", name1.equals(name4));
        assertFalse("Different names - equals", name4.equals(name1));
        assertFalse("equals with null", name1.equals(null));
        assertFalse("equals with non-Name object", name1.equals("String"));
        assertEquals("Test getters for name1", "Alice", name1.getFirstName());
        assertEquals("Test getters for name1", 'A', name1.getMiddleInitial());
        assertEquals("Test getters for name1", "Smith", name1.getLastName());
        assertEquals("Test unity ID for name1", "aasmith", name1.getUnityID());
        assertEquals("Test intitials for name1", "AAS", name1.getInitials());
        assertEquals("Test length for name1", 11, name1.length());
    }

    @Test
    public void testGivenExample() {
        Name name = new Name();
        name.setFirstName("John");
        name.setLastName("Public");
        name.setMiddle('Q');
        assertEquals("getNormalOrder", "John Q. Public", name.getNormalOrder());
        assertEquals("getReverseOrder", "Public, John Q.", name.getReverseOrder());
        assertEquals("getUnityID", "jqpublic", name.getUnityID());
        assertEquals("getInitials", "JQP", name.getInitials());
        assertEquals("length", 11, name.length());
    }

    @Test
    public void testJohnJacobJingleheimerSchmidt() {
        Name name = new Name();
        name.setFirstName("John");
        name.setLastName("Schmidt");
        name.setMiddle('j');
        assertEquals("getNormalOrder", "John j. Schmidt", name.getNormalOrder());
        assertEquals("getReverseOrder", "Schmidt, John j.", name.getReverseOrder());
        assertEquals("getUnityID", "jjschmid", name.getUnityID());
        assertEquals("getInitials", "JJS", name.getInitials());
        assertEquals("length", 12, name.length());
    }

}
