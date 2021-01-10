import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Graphics interface for the planner
 */
public class PlannerGUI extends JFrame implements ActionListener {
    
    /** Instance field for the week that the planner is for */
    private static Week week;
    /** Instance field for the add event button */
    private JButton addEventButton;
    /** Instance field for the delete event button */
    private JButton deleteEventButton;
    /** Instance field for he add reminder button */
    private JButton addReminderButton;
    /** Instance field for the delete event button */
    private JButton deleteReminderButton;
    /** Instance field for the upload file button */
    private JButton uploadFileButton;
    /** Instance field for the print schedule button */
    private JButton printButton;
    /** Instance field for the view day button */
    private JButton viewDayButton;
    /** Instance field for the view week button */
    private JButton viewWeekButton;
    
    /**
     * Creates the GUI for the planner and adds all of the buttons
     */
    public PlannerGUI() {
        super("Weekly Planner");
        setSize(600, 400);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(4,2));
        add(panel);
        
        addEventButton = new JButton("Add event");
        panel.add(addEventButton);
        deleteEventButton = new JButton("Delete event");
        panel.add(deleteEventButton);
        addReminderButton = new JButton("Add reminder");
        panel.add(addReminderButton);
        deleteReminderButton = new JButton("Delete reminder");
        panel.add(deleteReminderButton);
        uploadFileButton = new JButton("Upload CSV file");
        panel.add(uploadFileButton);
        printButton = new JButton("Print schedule to .txt file");
        panel.add(printButton);
        viewDayButton = new JButton("View schedule (Day)");
        panel.add(viewDayButton);
        viewWeekButton = new JButton("View schedule (Week)");
        panel.add(viewWeekButton);
        
        addEventButton.addActionListener(this);
        deleteEventButton.addActionListener(this);
        addReminderButton.addActionListener(this);
        deleteReminderButton.addActionListener(this);
        uploadFileButton.addActionListener(this);
        printButton.addActionListener(this);
        viewDayButton.addActionListener(this);
        viewWeekButton.addActionListener(this);
        
        setVisible(true);
    }
    
    /**
     * Executes different commands depending on which button is pressed
     *
     * @param e ActionEvent that tells the program which button is pressed
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addEventButton) {
            String eventDay = null;
            String eventStartTime = null;
            String eventEndTime = null;
            String eventTitle = null;
            String eventDescription = null;
            
            int startTime = -1;
            int endTime = -1;
            
            Event addedEvent = null;
            
            eventDay = JOptionPane.showInputDialog("Day of event (Monday-Friday):");
            if(eventDay == null) {
            
            } else {
            	eventDay = eventDay.toLowerCase();
            	if (!(eventDay.equals("monday") || eventDay.equals("tuesday")
					|| eventDay.equals("wednesday") || eventDay.equals("thursday")
					|| eventDay.equals("friday"))) {
					JOptionPane.showMessageDialog(null, "Invalid weekday");
				} else {
					eventStartTime = JOptionPane.showInputDialog("Start time (Military Time):");
					if(eventStartTime == null) {
					
					} else {
						try {
							startTime = Integer.parseInt(eventStartTime);
							eventEndTime = JOptionPane.showInputDialog("End time (Military Time):");
							if(eventEndTime == null) {
								
							} else {
								try {
									endTime = Integer.parseInt(eventEndTime);
									eventTitle = JOptionPane.showInputDialog("Event title:");
									if(eventTitle == null) {
										
									} else {
										eventDescription = JOptionPane.showInputDialog("Description of event:");
										if(eventDescription == null) {
											JOptionPane.showMessageDialog(null, "Please enter an event description");
										} else {
											addedEvent = new Event(startTime, endTime, eventTitle, eventDescription);
											for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
												Day weekDay = week.getSpecificDay(dayIndex);
												if(eventDay.equals(weekDay.getDayName())) {
													if(weekDay.getEvents().size() == 0) {
														week.addEventToWeek(dayIndex, addedEvent);
													} else {
														int lastEventsSize = weekDay.getEvents().size();
														for(int eventIndex = 0; eventIndex < lastEventsSize; eventIndex++) {
															ArrayList<Event> currentEvents = weekDay.getEvents();
															Event lastAddedEvent = null;
															if(!currentEvents.get(eventIndex).isConflict(addedEvent)) {
																week.addEventToWeek(eventIndex, addedEvent);
																lastAddedEvent = addedEvent;
															} else {
																if(!lastAddedEvent.equals(addedEvent)
																	|| currentEvents.get(eventIndex).isConflict(addedEvent)) {
																	JOptionPane.showMessageDialog(null, "There is conflict");
																}
															}
														}
													}
												}
											}
										}
									}
								} catch (NumberFormatException n) {
									JOptionPane.showMessageDialog(null, "Invalid time");
								}
							}
						} catch (NumberFormatException n) {
							JOptionPane.showMessageDialog(null, "Invalid time");
						}
					}
				}
            }
        }
        
        if(e.getSource() == deleteEventButton) {
        	String eventDay = null;
        	String eventTitle = null;
        
            eventDay = JOptionPane.showInputDialog("Day of event to delete:");
            if(eventDay == null) {
				
            } else {
            	eventDay = eventDay.toLowerCase();
				if(!(eventDay.equals("monday") || eventDay.equals("tuesday")
					|| eventDay.equals("wednesday") || eventDay.equals("thursday")
					|| eventDay.equals("friday"))) {
					JOptionPane.showMessageDialog(null, "Invalid weekday");
				} else {
					eventTitle = JOptionPane.showInputDialog("Title of event to delete:");
					if(eventTitle == null) {
					
					} else {
						for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
							Day weekDay = week.getSpecificDay(dayIndex);
							if(eventDay.equals(weekDay.getDayName())) {
								ArrayList<Event> currentEvents = weekDay.getEvents();
								if(currentEvents.size() == 0) {
									JOptionPane.showMessageDialog(null, "Event not found");
								} else {
									for(int eventIndex = 0; eventIndex < weekDay.getEvents().size(); eventIndex++) {
										if(eventTitle.equals(currentEvents.get(eventIndex).getTitle())) {
											week.deleteEventFromWeek(dayIndex, eventIndex);
											eventIndex += 1000;
										} else if(!eventTitle.equals(currentEvents.get(eventIndex).getTitle())
													&& eventIndex == weekDay.getEvents().size() - 1){
											JOptionPane.showMessageDialog(null, "Event not found");
										}
									}
								}
							}
						}
					}
				}
			}
        }
        
        if(e.getSource() == addReminderButton) {
            String reminderDay = null;
            String reminderTime = null;
            String reminderTitle = null;
            String reminderDescription = null;
            
            int time = -1;
            
            Reminder addedReminder = null;
            
            reminderDay = JOptionPane.showInputDialog("Day of reminder (Monday-Friday):");
            if(reminderDay == null) {
				
            } else {
            	reminderDay = reminderDay.toLowerCase();
            	if (!(reminderDay.equals("monday") || reminderDay.equals("tuesday")
					|| reminderDay.equals("wednesday") || reminderDay.equals("thursday")
					|| reminderDay.equals("friday"))) {
					JOptionPane.showMessageDialog(null, "Invalid weekday");
				} else {
					reminderTime = JOptionPane.showInputDialog("Time (Military Time):");
					if(reminderTime == null) {
						
					} else {
						try {
							time = Integer.parseInt(reminderTime);
							reminderTitle = JOptionPane.showInputDialog("Reminder title:");
							if(reminderTitle == null) {
								
							} else {
								reminderDescription = JOptionPane.showInputDialog("Description of reminder:");
								if(reminderDescription == null) {
									
								} else {
									addedReminder = new Reminder(time, reminderTitle, reminderDescription);
									for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
										Day weekDay = week.getSpecificDay(dayIndex);
										if(reminderDay.equals(weekDay.getDayName())) {
											week.addReminderToWeek(dayIndex, addedReminder);
										}
									}
								}
							}
						} catch (NumberFormatException n) {
							JOptionPane.showMessageDialog(null, "Invalid time");
						}
					}
				}
            }
        }
        
        if(e.getSource() == deleteReminderButton) {
        	String reminderDay = null;
        	String reminderTitle = null;
        
            reminderDay = JOptionPane.showInputDialog("Day of reminder to delete:");
            if(reminderDay == null) {
				
            } else {
            	reminderDay = reminderDay.toLowerCase();
				if(!(reminderDay.equals("monday") || reminderDay.equals("tuesday")
					|| reminderDay.equals("wednesday") || reminderDay.equals("thursday")
					|| reminderDay.equals("friday"))) {
					JOptionPane.showMessageDialog(null, "Invalid weekday");
				} else {
					reminderTitle = JOptionPane.showInputDialog("Title of reminder to delete:");
					if(reminderTitle == null) {
						
					} else {
						for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
							Day weekDay = week.getSpecificDay(dayIndex);
							if(reminderDay.equals(weekDay.getDayName())) {
								ArrayList<Reminder> currentReminders = weekDay.getReminders();
								if(currentReminders.size() == 0) {
									JOptionPane.showMessageDialog(null, "Reminder not found");
								} else {
									for(int reminderIndex = 0; reminderIndex < weekDay.getReminders().size(); reminderIndex++) {
										if(reminderTitle.equals(currentReminders.get(reminderIndex).getTitle())) {
											week.deleteReminderFromWeek(dayIndex, reminderIndex);
											reminderIndex += 1000;
										} else if(!reminderTitle.equals(currentReminders.get(reminderIndex).getTitle())
													&& reminderIndex == weekDay.getReminders().size() - 1){
											JOptionPane.showMessageDialog(null, "Reminder not found");
										}
									}
								}
							}
						}
					}
				}
			}
        }
        
        if(e.getSource() == uploadFileButton) {
        	File file = null;
        
            String fileName = JOptionPane.showInputDialog("File name (with directory):");
            if(fileName == null) {
            	JOptionPane.showMessageDialog(null, "Please enter a file name (with directory)");
            } else {
            	file = new File(fileName);
            	if(!file.exists()) {
            		JOptionPane.showMessageDialog(null, "No such file or directory");
				} else {
					Scanner input = null;
					try {
						input = new Scanner(file);
					} catch (FileNotFoundException er) {
						JOptionPane.showMessageDialog(null, "Error reading file");
					}
			
					Scanner lineScan = null;
			
					while(input.hasNextLine()) {
						lineScan = new Scanner(input.nextLine());
						lineScan.useDelimiter(",");
						while(lineScan.hasNext()) {
							String day = lineScan.next().toLowerCase();
							if(!(day.equals("monday") || day.equals("tuesday")
								|| day.equals("wednesday") || day.equals("thursday")
								|| day.equals("friday"))) {
								JOptionPane.showMessageDialog(null, "Incorrect format");
							} else {
								String type = lineScan.next().toLowerCase();
								if(type.equals("event")) {
									int startingTime = lineScan.nextInt();
									int endingTime = lineScan.nextInt();
									String title = lineScan.next();
									String description = lineScan.next();

									Event eventToBeAdded = new Event(startingTime, endingTime, title,
																		description);

									for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
										Day weekDay = week.getSpecificDay(dayIndex);
										if(day.equals(weekDay.getDayName())) {
											if(weekDay.getEvents().size() == 0) {
												week.addEventToWeek(dayIndex, eventToBeAdded);
											} else {
												int lastEventsSize = weekDay.getEvents().size();
												for(int eventIndex = 0; eventIndex < lastEventsSize;
													eventIndex++) {
													ArrayList<Event> currentEvents = weekDay.getEvents();
													if(!currentEvents.get(eventIndex).isConflict(eventToBeAdded)) {
														week.addEventToWeek(eventIndex, eventToBeAdded);
													} else {
														Event lastAddedEvent = eventToBeAdded;
														if(!lastAddedEvent.equals(eventToBeAdded)
															|| currentEvents.get(eventIndex).isConflict(eventToBeAdded)) {
															JOptionPane.showMessageDialog(null, "There is a conflict");
														}
													}
												}
											}
										}
									}
								} else if(type.equals("reminder")) {
									int time = lineScan.nextInt();
									String title = lineScan.next();
									String description = lineScan.next();

									Reminder reminderToBeAdded = new Reminder(time, title, description);

									for(int dayIndex = 0; dayIndex < week.getDays().length; dayIndex++) {
										Day weekDay = week.getSpecificDay(dayIndex);
										if(day.equals(weekDay.getDayName())) {
											week.addReminderToWeek(dayIndex, reminderToBeAdded);
										}
									}
								} else {
									JOptionPane.showMessageDialog(null, "Incorrect format");
								}
							}
						}
					}
				}
            }
        }
        
        if(e.getSource() == printButton) {
            String dayOrWeek = JOptionPane.showInputDialog("Print one day (\"day\") or whole week (\"week\")?");
            if(dayOrWeek == null) {
            
            } else {
				dayOrWeek = dayOrWeek.toLowerCase();
				if(!(dayOrWeek.equals("week") || dayOrWeek.equals("day"))) {
					JOptionPane.showMessageDialog(null, "Please type \"day\" or \"week\"");
				} else {
					PrintStream printedSchedule = null;
					
					if(dayOrWeek.equals("week")) {
						String fileName = JOptionPane.showInputDialog("Directory and file name for new file:");
						if(fileName == null) {
							
						} else {
							try {
								printedSchedule = new PrintStream(new File(fileName));
								printedSchedule.print(week.toString());
							} catch (FileNotFoundException f) {
								JOptionPane.showMessageDialog(null, "Could not print file");
							}
						}
					} else if(dayOrWeek.equals("day")) {
						String fileName = JOptionPane.showInputDialog("Directory and file name for new file:");
						if(fileName == null) {
							
						} else {
							String day = JOptionPane.showInputDialog("Which day?");
							if(day == null) {
				
							} else {
								day = day.toLowerCase();
								if(!(day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") ||
										day.equals("thursday") || day.equals("friday"))) {
									JOptionPane.showMessageDialog(null, "Please enter a weekday (Monday-Friday)");
								} else {
									Day dayToPrint = null;
									Day[] daysInWeek = week.getDays();
									for(int dayIndex = 0; dayIndex < daysInWeek.length; dayIndex++) {
										String currentDay = daysInWeek[dayIndex].getDayName();
										if(day.equals(currentDay)) {
											dayToPrint = daysInWeek[dayIndex];
										}
									}
									try {
										printedSchedule = new PrintStream(new File(fileName));;
										printedSchedule.print(dayToPrint.toString());
									} catch (FileNotFoundException f) {
										JOptionPane.showMessageDialog(null, "Could not print file");
									}
								}
							}
						}
					}
				}
            }
        }
        
        if(e.getSource() == viewDayButton) {
            try {
				String day = JOptionPane.showInputDialog(null, "Which day would you like to view?");
                day = day.toLowerCase();
				if(!(day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") ||
						day.equals("thursday") || day.equals("friday"))) {
					JOptionPane.showMessageDialog(null, "Please enter a weekday (Monday-Friday)");
				}
			
				Day[] daysInWeek = week.getDays();
				for(int i = 0; i < daysInWeek.length; i++) {
					String currentDay = daysInWeek[i].getDayName();
					if(day.equals(currentDay)) {
						Day dayToView = daysInWeek[i];
						View viewer = new View(dayToView);
                        //JOptionPane.showMessageDialog(null, dayToView.toString());
					}
				}
			} catch (NullPointerException err) {
				System.out.println("Empty day.");
			}
        }
        
        if(e.getSource() == viewWeekButton) {
            View weekViewer = new View(week);
            //JOptionPane.showMessageDialog(null, week.toString());
        }
    }
    
    /**
     * Constructs the week that the planner will use
     */
    public static void constructWeek() {
        Day[] daysInWeek = {new Day("monday"), new Day("tuesday"), new Day("wednesday"),
                                new Day("thursday"), new Day("friday")};
        week = new Week(daysInWeek);
    }
    
    /**
     * Starts the program
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        constructWeek();
        new PlannerGUI();
    }
}
