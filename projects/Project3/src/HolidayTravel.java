import java.util.Scanner;

/**
 *
 * Calculates the cost of train tickets purchased for travel.
 *
 * @author Selena Chen
 *
 */
public class HolidayTravel {
    /**
     * Declares constant variable for the year 2018
     */
    public static final int YEAR_2018 = 2018;
    
    /**
     * Declares constant variable for the year 2019
     */
    public static final int YEAR_2019 = 2019;
    
    /**
     * Declares constant variable for November
     */
    public static final int NOVEMBER = 11;
    
    /**
     * Declares constant variable for December
     */
    public static final int DECEMBER = 12;
    
    /**
     * Declares constant variable for January
     */
    public static final int JANUARY = 1;
    
    /**
     * Declares constant variable for the latest valid day in January
     */
    public static final int MAX_JANUARY_DAY = 15;
    
    /**
     * Declares constant variable for the number of months in a year plus two
     */
    public static final int MONTHS_IN_YEAR_PLUS_TWO = 14;
    
    /**
     * Declares constant variable for the number of months in a year
     */
    public static final int MONTHS_IN_YEAR = 12;
    
    /**
     * Declares constant variable for the frequency of leap years
     */
    public static final int LEAP_YEAR_FREQ = 4;
    
    /**
     * Declares constant variable for the number of years in a century
     */
    public static final int CENTURY_YEARS = 100;
    
    /**
     * Declares constant variable for the max number of days in a month
     */
    public static final int MAX_MONTH_DAYS = 31;
    
    /**
     * Declares constant variable for the max number of days in a month
     */
    public static final int DAYS_IN_WEEK = 7;
    
    /**
     * Declares constant variable for Monday
     */
    public static final int MONDAY = 1;
    
    /**
     * Declares constant variable for Thursday
     */
    public static final int THURSDAY = 4;
    
    /**
     * Declares constant variable for the cost of CLT ticket
     */
    public static final double CLT_TICKET = 50.0;
    
    /**
     * Declares constant variable for the cost of WDC ticket
     */
    public static final double WDC_TICKET = 100.0;
    
    /**
     * Declares constant variable for the cost of NYC ticket
     */
    public static final double NYC_TICKET = 180.0;
    
    /**
     * Declares constant variable for the $10 discount for weekday travel
     */
    public static final double DISCOUNT_PRICE = 10.0;

    /**
     *
     * Starts the program
     *
     * @param args command line arguments
     *
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println();
        
        System.out.println("        Thanks for choosing the Holiday Travel Special!");
        System.out.println("All trips depart from and return to Raleigh, NC, and must take");
        System.out.println("place between Nov 1, 2018 and Jan 15, 2019. When prompted, please");
        System.out.println("enter your destination: CLT (Charlotte,NC), WDC (Washington,DC),");
        System.out.println("or NYC (New York,NY), your departure/return dates, and the number");
        System.out.println("of adult and child tickets you would like to purchase - at least");
        System.out.println("one adult ticket must be purchased in order to purchase child");
        System.out.println("tickets. The total cost of the tickets will then be displayed.");
        
        System.out.println();
        
        System.out.print("Destination (CLT, WDC, NYC): ");
        String input = console.next();
        String destination = input.toUpperCase();
        if(!destination.equals("CLT") && !destination.equals("WDC") && !destination.equals("NYC")) {
            System.out.println("Invalid destination");
            System.exit(1);
        }
        
        System.out.print("Departure Month Day (e.g., 11 10): ");
        int departureMonth = console.nextInt();
        int departureDay = console.nextInt();
        
        System.out.print("Return Month Day (e.g., 11 15): ");
        int returnMonth = console.nextInt();
        int returnDay = console.nextInt();
        
        if(!areValidDates(departureMonth, departureDay, returnMonth, returnDay)) {
            System.out.println("Invalid date(s)");
            System.exit(1);
        }
        
        int departureYear = 0;
        if(departureMonth != 1) {
            departureYear = YEAR_2018;
        } else {
            departureYear = YEAR_2019;
        }
        
        int returnYear = 0;
        if(returnMonth == 1) {
            returnYear = YEAR_2019;
        } else {
            returnYear = YEAR_2018;
        }
        
        System.out.print("Number of Adult Tickets: ");
        int numberOfAdultTickets = console.nextInt();
        int numberOfChildTickets = 0;
        if(numberOfAdultTickets > 0) {
            System.out.print("Number of Child Tickets: ");
            numberOfChildTickets = console.nextInt();
        }
        
        if(numberOfAdultTickets < 0 || numberOfChildTickets < 0) {
            System.out.println("Invalid number of tickets");
            System.exit(1);
        }
        
        boolean weekdayTravel = false;
        if(isWeekday(departureMonth, departureDay, departureYear) &&
            isWeekday(returnMonth, returnDay, returnYear)) {
            weekdayTravel = true;
        }
        
        System.out.print("Cost of Tickets: $" + getCost(destination, numberOfAdultTickets,
                            numberOfChildTickets, weekdayTravel) + ".00");
        System.out.println();
    }

    /**
     *
     * Returns true if the departure/return dates are valid dates between Nov 1 and Jan 15
     * and the departure date occurs before or is the same as the return date
     *
     * @param departureMonth month of departure
     * @param departureDay day of departure
     * @param returnMonth month of return
     * @param returnDay day of return
     * @return true or false
     *
     */
    public static boolean areValidDates(int departureMonth, int departureDay,
                                     int returnMonth, int returnDay) {
        if((departureMonth != NOVEMBER && departureMonth != DECEMBER && departureMonth != JANUARY)
            || (returnMonth != NOVEMBER && returnMonth != DECEMBER && returnMonth != JANUARY)) {
            return false;
        } else if(departureMonth == DECEMBER && returnMonth == NOVEMBER) {
            return false;
        } else if(departureMonth == JANUARY &&
                    (returnMonth == NOVEMBER || returnMonth == DECEMBER)) {
            return false;
        } else if(departureMonth == returnMonth && departureDay > returnDay) {
            return false;
        }
        return !((departureMonth == JANUARY && returnMonth == JANUARY) &&
                (departureDay > MAX_JANUARY_DAY || returnDay > MAX_JANUARY_DAY));
        
    }

    /**
     *
     * Returns true if the date falls on Monday through Thursday
     *
     * @param month month
     * @param day day
     * @param year year
     * @return true or false
     *
     */
    public static boolean isWeekday(int month, int day, int year) {
        int w;
        int x;
        int z;
        int dayOfWeek;
        w = year - (MONTHS_IN_YEAR_PLUS_TWO - month) / MONTHS_IN_YEAR;
        x = w + w / LEAP_YEAR_FREQ - w / CENTURY_YEARS + w / (LEAP_YEAR_FREQ * CENTURY_YEARS);
        z = month +  MONTHS_IN_YEAR * ((MONTHS_IN_YEAR_PLUS_TWO - month) / MONTHS_IN_YEAR) - 2;
        dayOfWeek = (day + x + (MAX_MONTH_DAYS * z) / MONTHS_IN_YEAR) % DAYS_IN_WEEK;
        if(dayOfWeek >= MONDAY && dayOfWeek <= THURSDAY) {
            return true;
        }
        return false;
    }

    /**
     *
     * Calculates and returns cost of tickets based on destination, price of ticket,
     * weekday discount, and half-price child tickets for each adult ticket purchase
     *
     * @param destination destination (CLT, WDC, or NYC)
     * @param numberOfAdultTickets number of adult tickets
     * @param numberOfChildTickets number of child tickets
     * @param weekdayTravel whether or not the weekday discount applies
     * @return totalCost total cost of ticket(s)
     *
     */
    public static int getCost(String destination, int numberOfAdultTickets,
                                int numberOfChildTickets, boolean weekdayTravel) {
        destination = destination.toUpperCase();
        if(!destination.equals("CLT") && !destination.equals("WDC") && !destination.equals("NYC")) {
            throw new IllegalArgumentException("Invalid destination");
        }
        if(numberOfAdultTickets < 0 || numberOfChildTickets < 0) {
            throw new IllegalArgumentException("Invalid number of tickets");
        }
        if(numberOfAdultTickets == 0 && numberOfChildTickets > 0) {
            throw new IllegalArgumentException("Invalid number of tickets");
        }
        double ticketCost = CLT_TICKET;
        if(destination.equals("WDC")) {
            ticketCost = WDC_TICKET;
        } else if(destination.equals("NYC")) {
            ticketCost = NYC_TICKET;
        }
        double adultCost = numberOfAdultTickets * ticketCost;
        int numberOfHalfChildTickets = numberOfAdultTickets;
        if(numberOfAdultTickets > numberOfChildTickets) {
            numberOfHalfChildTickets = numberOfChildTickets;
        }
        int numberOfFullChildTickets = numberOfChildTickets - numberOfHalfChildTickets;
        double halfChildCost = numberOfHalfChildTickets * ticketCost / 2.0;
        double fullChildCost = numberOfFullChildTickets * ticketCost;
        double childCost = halfChildCost + fullChildCost;
        if(weekdayTravel) {
            adultCost -= numberOfAdultTickets * DISCOUNT_PRICE;
            childCost -= numberOfChildTickets * DISCOUNT_PRICE;
        }
        int totalCost = (int)(adultCost + childCost);
        return totalCost;
    }
}
