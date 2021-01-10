import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Class for viewing a single day's worth of events and reminders or a whole week's worth of events
 * and reminders
 *
 * @author Joseph Dasilva
 * @author Selena Chen
 * @author Sarah Peterson
 */
public class View extends JFrame {
    /** Instance field for the current day */
    private JLabel currentDay;

    /**
     * Constructor method for viewing a week
     */
    public View(Week week) {
        super("Weekly Planner Viewer");
        setSize(1250, 600);
        setLocation(100, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        int eventsSize = -1;
        int maxEventsSize = -1;
        for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        	eventsSize = week.getSpecificDay(dayIndex).getEvents().size();
        	if(Math.max(maxEventsSize, eventsSize) == eventsSize) {
        		maxEventsSize = eventsSize;
        	}
        }
        if(maxEventsSize == -1) {
        	maxEventsSize = 0;
        }
        
        int remindersSize = -1;
        int maxRemindersSize = -1;
        for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        	remindersSize = week.getSpecificDay(dayIndex).getReminders().size();
        	if(Math.max(maxRemindersSize, remindersSize) == remindersSize) {
        		maxRemindersSize = remindersSize;
        	}
        }
        if(maxRemindersSize == -1) {
        	maxRemindersSize = 0;
        }
        
        int numberOfLabels = maxEventsSize + maxRemindersSize + 3;

        JPanel panel = new JPanel(new GridLayout(numberOfLabels, week.getDays().length));
        add(panel);
        
        for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        	String dayName = week.getSpecificDay(dayIndex).getDayName();
        	dayName = dayName.toUpperCase().substring(0, 1) + dayName.substring(1);
            JLabel currentDayName = new JLabel(dayName);
            panel.add(currentDayName);
        }
        
        for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        	JLabel eventsLabel = new JLabel("Events:");
            panel.add(eventsLabel);
        }
        
        for(int eventIndex = 0; eventIndex < maxEventsSize; eventIndex++) {
        	for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        		int currentEventSize = week.getSpecificDay(dayIndex).getEvents().size();
        		if(currentEventSize > eventIndex) {
        			Event currentEvent = week.getSpecificDay(dayIndex).getEvents().get(eventIndex);
        			int startingTime = currentEvent.getStartingTime();
					int endingTime = currentEvent.getEndingTime();
					String timeRange = "" + startingTime + " - " + endingTime;
					String title = currentEvent.getTitle();
					String description = currentEvent.getDescription();
					JLabel currentEventLabel = new JLabel("<html><br />" + timeRange + "<br />" + title
											+ "<br />" + description + "</html>");
					panel.add(currentEventLabel);
				} else {
					JLabel emptyPanel = new JLabel("<html><br /><br /><br /></html>");
					panel.add(emptyPanel);
				}
        	}
        }
        
        for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        	JLabel remindersLabel = new JLabel("Reminders:");
            panel.add(remindersLabel);
        }
        
        for(int reminderIndex = 0; reminderIndex < maxRemindersSize; reminderIndex++) {
        	for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
        		int currentReminderSize = week.getSpecificDay(dayIndex).getReminders().size();
        		if(currentReminderSize > reminderIndex) {
        			Reminder currentReminder = week.getSpecificDay(dayIndex).getReminders().get(reminderIndex);
        			int time = currentReminder.getTime();
					String title = currentReminder.getTitle();
					String description = currentReminder.getDescription();
					JLabel currentReminderLabel = new JLabel("<html><br />" + time + "<br />" + title
											+ "<br />" + description + "</html>");
					panel.add(currentReminderLabel);
				} else {
					JLabel emptyPanel = new JLabel("<html><br /><br /></html>");
					panel.add(emptyPanel);
				}
        	}
        }
        
        setSize(1250, numberOfLabels * 75);
            
        setVisible(true);
    }

    /**
     * Constructor method for viewing a day
     */
    public View(Day day) {
        super("Daily Planner Viewer");
        setSize(200, 100);
        setLocation(100, 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        int eventsSize = day.getEvents().size();
        Event currentEvent = null;

        int remindersSize = day.getReminders().size();
        Reminder currentReminder = null;

        int numberOfLabels = eventsSize + remindersSize + 3;

        JPanel panel = new JPanel(new GridLayout(numberOfLabels, 1));
        add(panel);

        String dayName = day.getDayName();
        dayName = dayName.toUpperCase().substring(0, 1) + dayName.substring(1);
        JLabel currentDayName = new JLabel(dayName);
        panel.add(currentDayName);

        JLabel eventsLabel = new JLabel("Events:");
        panel.add(eventsLabel);

        for(int eventIndex = 0; eventIndex < eventsSize; eventIndex++) {
            currentEvent = day.getEvents().get(eventIndex);
            int startingTime = currentEvent.getStartingTime();
            int endingTime = currentEvent.getEndingTime();
            String timeRange = "" + startingTime + " - " + endingTime;
            String title = currentEvent.getTitle();
            String description = currentEvent.getDescription();
            currentDay = new JLabel("<html>" + timeRange + "<br />" + title
                                    + "<br />" + description + "<br /></html>");
            panel.add(currentDay);
        }

        JLabel remindersLabel = new JLabel("Reminders:");
        panel.add(remindersLabel);

        for(int reminderIndex = 0; reminderIndex < remindersSize; reminderIndex++) {
            currentReminder = day.getReminders().get(reminderIndex);
            int time = currentReminder.getTime();
            String title = currentReminder.getTitle();
            String description = currentReminder.getDescription();
            currentDay = new JLabel("<html>" + dayName + "<br />" + time + "<br />" + title
                                    + "<br />" + description + "<br /></html>");
            panel.add(currentDay);
        }

        setSize(300, numberOfLabels * 75);
        
        setVisible(true);
    }
}