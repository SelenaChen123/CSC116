import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program to test PayGap methods
 * @author Suzanne Balik
 * @author Selena Chen
 */
public class PayGapTest extends TestCase {

    public static final Job BUTCHER = new Job("Butcher", 34200, 36575);
    
    public static final Job BAKER = new Job("Baker", 29800, 30450);
    
    public static final Job CANDLESTICK_MAKER = new Job("Candlestick maker", 34080, 39896);
    
    public static final Job CASHIER = new Job("Cashier", 20124, 21424);
    
    public static final Job[] THREE_JOBS = { BUTCHER, BAKER, CANDLESTICK_MAKER };
    
    public static final Job[] FOUR_JOBS = { BUTCHER, BAKER, CANDLESTICK_MAKER, CASHIER };

    @Test
    public void testGetJobList1() {
        String filename = "test-files/three_jobs.csv";
        Job[] actual = PayGap.getJobList(filename);
        assertTrue(filename, Arrays.equals(THREE_JOBS, actual));
    }
    
    @Test
    public void testGetJobList2() {
        String filename = "test-files/my_jobs.csv";
        Job[] actual = PayGap.getJobList(filename);
        assertTrue(filename, Arrays.equals(FOUR_JOBS, actual));
    }

    @Test
    public void testGetAllJobs1() {
        String expected = "Butcher                                                   "
                + "             34200    36575\n"
                + "Baker                                                             "
                + "     29800    30450\n"
                + "Candlestick maker                                                 "
                + "     34080    39896\n";
        String actual = PayGap.getAllJobs(THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }
    
    @Test
    public void testGetAllJobs2() {
        String expected = "Butcher                                                   "
                + "             34200    36575\n"
                + "Baker                                                             "
                + "     29800    30450\n"
                + "Candlestick maker                                                 "
                + "     34080    39896\n"
                + "Cashier                                                           "
                + "     20124    21424\n";
        String actual = PayGap.getAllJobs(FOUR_JOBS);
        assertEquals("Four jobs", expected, actual);
    }

    @Test
    public void testSearchByJob1() {
        String expected = "Candlestick maker                                         "
                + "             34080    39896\n";
        String actual = PayGap.searchByJob("ck ma", THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }
    
    @Test
    public void testSearchByJob2() {
        String expected = "Cashier                                                   "
                + "             20124    21424\n";
        String actual = PayGap.searchByJob("cash", FOUR_JOBS);
        assertEquals("Four jobs", expected, actual);
    }


    @Test
    public void testSearchBySalaryRange1() {
        String expected = "Butcher                                                    "
                + "            34200    36575\n";
        String actual = PayGap.searchBySalaryRange(34000, 37000, THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }
    
    @Test
    public void testSearchBySalaryRange2() {
        String expected = "Cashier                                                    "
                + "            20124    21424\n";
        String actual = PayGap.searchBySalaryRange(20000, 22000, FOUR_JOBS);
        assertEquals("Four jobs", expected, actual);
    }

    @Test
    public void testSearchByPercentage1() {
        String expected = "Butcher                                                  "
                + "              34200    36575\n"
                + "Candlestick maker                                                "
                + "      34080    39896\n";
        String actual = PayGap.searchByPercentage(95, THREE_JOBS);
        assertEquals("Three jobs", expected, actual);
    }
    
    @Test
    public void testSearchByPercentage2() {
        String expected = "Butcher                                                  "
                + "              34200    36575\n"
                + "Candlestick maker                                                "
                + "      34080    39896\n"
                + "Cashier                                                          "
                + "      20124    21424\n";
        String actual = PayGap.searchByPercentage(95, FOUR_JOBS);
        assertEquals("Four jobs", expected, actual);
    }

    /**
     * Test the PayGap methods with invalid values
     */ 
    @Test
    public void testSearchInvalid() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            PayGap.searchBySalaryRange(40000, 37000, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            PayGap.searchBySalaryRange(-300, 37000, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            PayGap.searchBySalaryRange(40000, -50000, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            PayGap.searchByPercentage(0, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid percentage value", e.getMessage());
        }

        try {
            PayGap.searchByPercentage(101, THREE_JOBS);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid percentage value", e.getMessage());
        }
    }

}