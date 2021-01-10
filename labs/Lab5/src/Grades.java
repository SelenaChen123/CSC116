/**
* Converts a student's score from 0 to 100 to a grade on the 4.0 scale
* @author Selena Chen
* @author Ayushi Verma
*/
public class Grades {
    /**
     * Starts the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        final int TEST_1 = 0;
        final int TEST_2 = 45;
        final int TEST_3 = 60;
        final int TEST_4 = 63;
        final int TEST_5 = 80;
        final int TEST_6 = 90;
        final int TEST_7 = 95;
        final int TEST_8 = 100;
        System.out.println("Parameter = 0, Return value = " + grade(TEST_1));
        System.out.println("Parameter = 45, Return value = " + grade(TEST_2));
        System.out.println("Parameter = 60, Return value = " + grade(TEST_3));
        System.out.println("Parameter = 63, Return value = " + grade(TEST_4));
        System.out.println("Parameter = 80, Return value = " + grade(TEST_5));
        System.out.println("Parameter = 90, Return value = " + grade(TEST_6));
        System.out.println("Parameter = 95, Return value = " + grade(TEST_7));
        System.out.println("Parameter = 100, Return value = " + grade(TEST_8));
    }
    
    /**
     * Accepts an integer parameter representing a student's course grade from 0 to 100
     * and returns the student's course grade on the 4.0 scale
     * 
     * @param score student's score from 0 to 100
     * @return grade grade on the 4.0 scale
     */
    public static double grade(int score) {
        final int MIN_GRADE = 60;
        final int INCREMENT = 7;
        double grade = (score - MIN_GRADE) / 10.0;
        for(double i = grade; i < 0.0; i += INCREMENT) {
            grade = 0.0;
        }
        return grade;
    }
}