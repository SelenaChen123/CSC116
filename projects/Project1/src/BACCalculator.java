/**
 * Calculates and outputs BAC values
 *
 * @author Selena Chen
 */
public class BACCalculator {
    /**
     * Declares constant variable for blood alcohol content
     */
    public static final double BAC_CONSTANT = 0.016;
    /**
     * Declares constant variable for the gender constant for men
     */
    public static final double MAN_CONSTANT = 9.0;
    /**
     * Declares constant variable for the min weight for men
     */
    public static final int MAN_MIN_WEIGHT = 140;
    /**
     * Declares constant variable for the max weight for men
     */
    public static final int MAN_MAX_WEIGHT = 180;
    /**
     * Declares constant variable for the gender constant for women
     */
    public static final double WOMAN_CONSTANT = 7.5;
    /**
     * Declares constant variable for the min weight for women
     */
    public static final int WOMAN_MIN_WEIGHT = 100;
    /**
     * Declares constant variable for the max weight for women
     */
    public static final int WOMAN_MAX_WEIGHT = 140;
    /**
     * Declares constant variable for the incremental change in weight
     */
    public static final int WEIGHT_INCREMENT = 20;
    /**
     * Declares constant variable for the max number of drinks
     */
    public static final int MAX_DRINKS = 10;
    /**
     * Declares constant variable for the max number of hours since the first drink
     */
    public static final int MAX_HOURS = 3;

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("                          Blood Alcohol Content (BAC)");
        System.out.println("Drinks                 Man                           Woman");
        System.out.print("(3 hrs)   (140 lbs) (160 lbs) (180 lbs)  ");
        System.out.println("(100 lbs) (120 lbs) (140 lbs)");
        System.out.print("-------   --------- --------- ---------  ");
        System.out.println("--------- --------- ---------");
        for(int i = 1; i <= MAX_DRINKS; i++) {
            System.out.printf("%4d", i);
            System.out.print("   ");
            for(int j = MAN_MIN_WEIGHT; j <= MAN_MAX_WEIGHT; j += WEIGHT_INCREMENT) {
                System.out.printf("%10.3f", calculateBAC(MAN_CONSTANT, j, i, MAX_HOURS));
            }
            System.out.print(" ");
            for(int k = WOMAN_MIN_WEIGHT; k <= WOMAN_MAX_WEIGHT; k += WEIGHT_INCREMENT) {
                System.out.printf("%10.3f", calculateBAC(WOMAN_CONSTANT, k, i, MAX_HOURS));
            }
            System.out.println();
        }
    }

    /**
     * Calculates Blood Alcohol Content (BAC) based on a person's gender, weight,
     * the number of drinks that have been consumed, and the number of hours 
     * since the first drink was consumed.
     * 
     * @param genderConstant gender constant for person
     * @param weight weight of person
     * @param numberOfDrinks number of drinks consumed by person
     * @param hoursDrinking number of hours since first drink was consumed
     * @return Returns the calculated blood alcohol content if it is positive, 0.0 otherwise
     */        
    public static double calculateBAC(double genderConstant, double weight, int numberOfDrinks, 
                                  int hoursDrinking) {
        double bac = genderConstant / weight * numberOfDrinks / 2 - BAC_CONSTANT * hoursDrinking;
        for(double i = bac; i <= 0.0; i += 1) {
            bac = 0.0; 
        } 
        return bac;
    }
}