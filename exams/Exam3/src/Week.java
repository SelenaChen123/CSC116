/**
 * Class for the week that is being scheduled
 *
 * @author Sarah Peterson
 * @author Selena Chen
 * @author Joseph Dasilva
 */
public class Week {

    /** Instance field for the Days in the week */
    private Day[] days;

    /**
     * Constructor method for the Week
     *
     * @param days Days in the week
     */
    public Week(Day[] days) {
        this.days = days;
    }
    
    /**
     * Getter method for the Days in the Week
     *
     * @return days Days in the week
     */
    public Day[] getDays() {
        return days;
    }
    
    /**
     * Getter method for a specific Day in the week, given an index
     *
     * @param index index of the Day
     * @return specificDay specific Day in the week
     */
    public Day getSpecificDay(int index) {
        return days[index];
    }
    
    /**
     * Adds Event object to Week
     *
     * @param index index of Day being added to Week
     * @param event Event being added
     */
    public void addEventToWeek(int index, Event event) {
        days[index].addEventToDay(event);
    }
    
    /**
     * Adds Reminder object to Week
     *
     * @param index index of Reminder being added to Week
     * @param reminder Reminder being added
     */
    public void addReminderToWeek(int index, Reminder reminder) {
        days[index].addReminderToDay(reminder);
    }
    
    /**
     * Deletes Event object from Week
     *
     * @param dayIndex index of Day where Event is being removed from Week
     * @param eventIndex index of Event being removed from Week
     */
    public void deleteEventFromWeek(int dayIndex, int eventIndex) {
        days[dayIndex].deleteEventFromDay(eventIndex);
    }
    
    /**
     * Deletes Reminder object from Week
     *
     * @param dayIndex index of Day where Reminder is being removed from Week
     * @param reminderIndex index of Reminder being removed from Week
     */
    public void deleteReminderFromWeek(int dayIndex, int reminderIndex) {
        days[dayIndex].deleteReminderFromDay(reminderIndex);
    }

    /**
     * Returns a string version of the events and reminders in the week
     *
     * @return weekString List of events and reminders on every day of the week
     */
    public String toString() {
        String weekString = "";
        for(int i = 0; i < days.length; i++) {
            weekString += days[i].toString();
        }
        return weekString;
    }
}