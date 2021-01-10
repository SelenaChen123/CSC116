import java.util.*;

/**
 * Class for a day in the week
 *
 * @author Sarah Peterson
 * @author Selena Chen
 * @author Joseph Dasilva
 */
public class Day {
    
    /** Instance field for the events in the Day as an ArrayList */
    private ArrayList<Event> events = new ArrayList();
    /** Instance field for the reminders in the Day as an ArrayList */
    private ArrayList<Reminder> reminders = new ArrayList();
    /** Instance field for the name of the Day */
    private String dayName;

    /**
     * Constructor for the Day object
     *
     * @param dayname for the name of the day
     */
    public Day(String dayName) {
        this.dayName = dayName.toLowerCase();
    }
    
    /**
     * Getter method for Event array in the Day object
     *
     * @return events Event array in the Day object
     */
    public ArrayList<Event> getEvents() {
        return events;
    }
    
    /**
     * Getter method for the Reminder array in the Day object
     
     * @return reminders Reminder array in the Day object
     */
    public ArrayList<Reminder> getReminders() {
        return reminders;
    }
    
    /**
     * Getter method for the name of the Day
     *
     * @param dayName Name of the Day
     */
    public String getDayName() {
        return dayName;
    }
    
    /**
     * Adds Event object to events array
     *
     * @param event Event to be added
     */
    public void addEventToDay(Event event) {
        if(events.size() == 0) { 
            events.add(event);
        } else {
        	int previousSize = events.size();
        	boolean added = false;
            for(int i = 0; i < previousSize; i++) {
                if(event.getStartingTime() < events.get(i).getStartingTime() && !added) {
                    events.add(i, event);
                    added = true;
                }
            }
        }
    }
    
    /**
     * Adds Reminder object to reminders array
     *
     * @param reminder Reminder to be added
     */
    public void addReminderToDay(Reminder reminder) {
        if(reminders.size() == 0) { 
            reminders.add(reminder);
        } else {
        	int previousSize = reminders.size();
        	boolean added = false;
            for(int i = 0; i < previousSize; i++) {
                if(reminder.getTime() < reminders.get(i).getTime() && !added) {
                    reminders.add(i, reminder);
                    added = true;
                }
            }
        }
    }
    
    /**
     * Deletes Event object from events array
     *
     * @param index Index of event to be deleted
     */
    public void deleteEventFromDay(int index) {
        events.remove(index);
    }
    
    /**
     * Deletes Reminder object from reminders array
     *
     * @param index Index of reminder to be deleted
     */
    public void deleteReminderFromDay(int index) {
        reminders.remove(index);
    }

    /**
     * Creates a String version of the Events and Reminders in the Day
     * 
     * @return stringDay List of events and reminders for the day
     */
    public String toString() {
        String firstLetter = "" + dayName.charAt(0);
        firstLetter = firstLetter.toUpperCase();
        String stringDay = firstLetter + dayName.substring(1,dayName.length()) + "\n\n\tEvents:\n\n";
        for(int i = 0; i < events.size(); i++) {
            stringDay = stringDay + "\t\t" + events.get(i).getStartingTime() + " - " + events.get(i).getEndingTime() + "\n";
            stringDay = stringDay + "\t\t" + events.get(i).getTitle() + "\n";
            stringDay = stringDay + "\t\t" + events.get(i).getDescription() + "\n";
        }
        stringDay += "\n\tReminders:\n\n";
        for(int i = 0; i < reminders.size(); i++) {
            stringDay = stringDay + "\t\t" + reminders.get(i).getTime() + "\n";
            stringDay = stringDay + "\t\t" + reminders.get(i).getTitle() + "\n";
            stringDay = stringDay + "\t\t" + reminders.get(i).getDescription() + "\n";
        }
        stringDay += "\n";
        return stringDay;
    }
}