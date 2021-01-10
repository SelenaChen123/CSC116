/**
 * Class for a Reminder object
 *
 * @author Sarah Peterson
 * @author Selena Chen
 * @author Joseph Dasilva
 */
public class Reminder {
    
    /** Instance field for the time of the Reminder */
    private int time;
    /** Instance field for the title of the Reminder */
    private String title;
    /** Instance field for the description of the Reminder */
    private String description;

    /**
     * Constructor for a Reminder object
     * @param date Day of the reminder
     * @param time Time of the reminder
     * @param title Title of the reminder
     * @param description Description of the reminder
     */
    public Reminder(int time, String title, String description) {
        this.time = time;
        this.title = title;
        this.description = description;
    }
    
    /**
     * Getter method for starting time
     *
     * @return time Time for event
     */
    public int getTime() {
        return time;
    }
    
    /**
     * Getter method for title
     *
     * @return title Title for event
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Getter method for description
     *
     * @return description Description for event
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Creates and returns a String version of the reminder
     *
     * @return String version of reminder
     */
    public String toString() {
    	String reminderString = "";
    	reminderString = time + "\n" + title + "\n" + description + "\n";
        return reminderString;
    }
    
    /**
     * This method determines if two reminders are equal
     *
     * @param reminder Reminder being compared to the current reminder to see if they're equal
     * @return true if they are equal, false if not
     */
    public boolean equals(Object object) {
        if (object instanceof Reminder) {
            Reminder other = (Reminder) object;
            return (time == other.getTime() && title.equals(other.getTitle()))
            		&& description.equals(other.getDescription());
        } else {
        	return false;
        }
    }
}