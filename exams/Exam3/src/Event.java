/**
 * Class for an Event object
 *
 * @author Sarah Peterson
 * @author Selena Chen
 * @author Joseph Dasilva
 */
public class Event{

    /** Instance field for starting time of event */
    private int startingTime;
    /** Instance field for ending time of the event */
    private int endingTime;
    /** Instance field for title of event */
    private String title;
    /** Instance field for description of event */
    private String description;
    
    /**
     * Constructor for Event
     *
     * @param startingTime Start time of event
     * @param endingTime End time of event
     * @param title Title of event
     * @param description Description of event
     */
    public Event(int startingTime, int endingTime, String title, String description){
        if (title == null) {
            throw new IllegalArgumentException("title is null");
        }
        if (description == null) {
            throw new IllegalArgumentException("description is null");
        }
        if (startingTime < 0 || startingTime > 2400 || 
            endingTime < 0 || endingTime > 2400 || endingTime <= startingTime) {
            throw new IllegalArgumentException("The times are invalid");
        }
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.title = title;
        this.description = description;
    }
    
    /**
     * Getter method for starting time
     *
     * @return startingTime Starting time for event
     */
    public int getStartingTime() {
        return startingTime;
    }
    
    /**
     * Getter method for ending time
     *
     * @return endingTime Ending time for event
     */
    public int getEndingTime() {
        return endingTime;
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
     * This method determines if two events have conflicting times
     *
     * @param event Event that is being compared to the current event to see if they conflicting
     * @return true if they conflict, false if not
     */
    public boolean isConflict(Object object) {
        if (object instanceof Event) {
            Event other = (Event) object;
            if(startingTime == other.getStartingTime() 
                || endingTime == other.getEndingTime()) {
            	return true;
        	} else if(other.getEndingTime() > startingTime
        				&& other.getEndingTime() < endingTime) {
            	return true;
        	} else if(other.getStartingTime() > startingTime && 
                		other.getStartingTime() < endingTime) {
            	return true;
        	} else if(other.getEndingTime() < startingTime
        				&& other.getEndingTime() > endingTime) {
            	return true;
        	} else if(other.getStartingTime() < startingTime && 
                		other.getStartingTime() > endingTime) {
            	return true;
        	} else {
        		return false;
        	}
        } else {
        	return false;
        }
    }
    
    /**
     * Creates and returns a String version of the event
     *
     * @return eventString String version of event
     */
    public String toString() {
        String eventString = "";
        eventString = startingTime + " - " + endingTime + "\n" + title + "\n" + description + "\n";
        return eventString;
    }
    
    /**
     * This method determines if two events are equal
     *
     * @param event Event that is being compared to the current event to see if they are equal
     * @return true if they are equal, false if not
     */
    public boolean equals(Object object) {
        if (object instanceof Event) {
            Event other = (Event) object;
            return (startingTime == other.getStartingTime() && endingTime == other.getEndingTime()
            		&& title.equals(other.getTitle()))
            		&& description.equals(other.getDescription());
        } else {
        	return false;
        }
    }
}