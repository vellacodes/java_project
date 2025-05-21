/**
 * Weekly Calendar- Scheduling System. Has sign ups for time slots on the weekly schedule   
 * @author Ameya and Vella
 * @version 5/19/25
 */

import java.awt.*;
import java.io.*;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.*;

/**
 * This is the WeeklyCalendar class, which displays a weekly calendar for scheduling.
 */
public class WeeklyCalendar extends Frame {


   // Fields to store calendar and user information
   private Calendar calendar;
   private int dayOfWeek;
   private String accountType;
   private String firstName;
   private String lastName;

/**
 * Constructor initializes the calendar and builds the UI
 * @param accountType - type of user (doctor, nurse, volunteer, staff)
 * @param firstName - first name of the user
 * @param lastName - last name of the user
 * @param timeSlot - time slot selected by the user
 */
   public WeeklyCalendar(String accountType, String firstName, String lastName, String timeSlot) {
       super("Scheduling");

       // Store user information
       this.accountType = accountType.toLowerCase();
       this.firstName = firstName;
       this.lastName = lastName;

       // Set up calendar data
       calendar = Calendar.getInstance();
       dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

       // Use BorderLayout for frame layout
       setLayout(new BorderLayout());

       // Create a tabbed pane for different user roles
       JTabbedPane tabbedPane = new JTabbedPane();

       // Define roles
       String[] roles = {"doctor", "nurse", "volunteer", "staff"};

       // Create a tab for each role
       for (String role : roles) {
           JPanel rolePanel = new JPanel(new BorderLayout());

           // Add a custom Canvas to visually show the calendar
           Canvas canvas = new CalendarCanvas();
           rolePanel.add(canvas, BorderLayout.CENTER);

           // Create a panel with day buttons (Sunday to Saturday)
           Panel buttonPanel = new Panel(new GridLayout(1, 7));
           String[] daysOfWeek = new java.text.DateFormatSymbols(Locale.getDefault()).getShortWeekdays();

           for (int i = 1; i <= 7; i++) {
               // Create a day button
               Button dayButton = new Button("Schedule " + daysOfWeek[i]);

               // Disable button if the tab does not match the user's account type
               if (!role.equals(this.accountType)) {
                   dayButton.setEnabled(false);
               }

               int dayIndex = i;

               // Add listener for valid scheduling buttons
               dayButton.addActionListener(e -> {
                   // Create a vertical panel with time slot buttons
                   JPanel panel = new JPanel();
                   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                   panel.add(new JLabel("Select the times you would like to schedule yourself:"));

                   // Time slot options
                   String[] timeSlots = {
                       "8:00am - 10:00am",
                       "10:00am - 12:00pm",
                       "2:00pm - 4:00pm"
                   };

                   // Create a button for each time slot
                   for (String slot : timeSlots) {
                       JButton btn = new JButton(slot);

                       // When a time slot is selected
                       btn.addActionListener(ev -> {
                           try {
                               // Append user info and selected slot to a CSV file
                               FileWriter writer = new FileWriter("users.csv", true);
                               BufferedWriter bw = new BufferedWriter(writer);
                               PrintWriter pw = new PrintWriter(bw);

                               pw.println(firstName + "," + accountType + "," + slot);
                               pw.close();

                               // Show confirmation popup
                               JOptionPane.showMessageDialog(this,
                                   "Your time slot has been confirmed.\n\n" +
                                   "Name: " + firstName + " " + lastName + "\n" +
                                   "Role: " + accountType + "\n" +
                                   "Time Slot: " + slot,
                                   "Confirmation",
                                   JOptionPane.INFORMATION_MESSAGE);
                           } catch (IOException ex) {
                               // Show error message if writing fails
                               JOptionPane.showMessageDialog(this, "Error saving to file." + ex, "Error", JOptionPane.ERROR_MESSAGE);
                               ex.printStackTrace();
                           }
                       });
                       panel.add(btn);
                   }
                   // Show time slot selection dialog
                   JOptionPane.showMessageDialog(this, panel, "Select Time Slot", JOptionPane.PLAIN_MESSAGE);
               });
               buttonPanel.add(dayButton); // Add each button to the day panel
           }
           rolePanel.add(buttonPanel, BorderLayout.SOUTH); // Add day panel to the bottom
           tabbedPane.addTab(capitalize(role), rolePanel); // Add tab to the tabbed pane
       }
       // Add the tabbed pane to the main frame
       add(tabbedPane, BorderLayout.CENTER);

       // Configure window
       setSize(800, 550);
       setVisible(true);
       addWindowListener(new java.awt.event.WindowAdapter() {
           public void windowClosing(java.awt.event.WindowEvent e) {
               dispose();
           }
       });
   }
/**
 * Inner class to draw the weekly calendar headers and dates
 */
   class CalendarCanvas extends Canvas {
       @Override
       public void paint(Graphics g) {
           int width = getWidth();
           int height = getHeight();
           int columnWidth = width / 7;

           String[] daysOfWeek = new java.text.DateFormatSymbols(Locale.getDefault()).getShortWeekdays();

           // Draw day names and grid lines
           for (int i = 0; i < 7; i++) {
               int x = i * columnWidth + columnWidth / 2;
               int yweek = 40;
               int yheader = 15;
               int ydivider = 50;
               String heading = "Welcome";
               int headingX = width / 2;

               // Draw title and day headers
               g.drawString(heading, headingX - g.getFontMetrics().stringWidth(heading) / 2, yheader);
               g.drawLine(0, ydivider, width, ydivider);
               g.drawString(daysOfWeek[i + 1], x - g.getFontMetrics().stringWidth(daysOfWeek[i + 1]) / 2, yweek);
               g.drawLine(i * columnWidth, 50, i * columnWidth, height);
           }

           // Final right border line
           g.drawLine(width - 1, 50, width - 1, height);

           // Draw actual dates below each day name
           Calendar tempCal = (Calendar) calendar.clone();
           tempCal.add(Calendar.DATE, -(dayOfWeek - tempCal.getFirstDayOfWeek()));


           for (int i = 0; i < 7; i++) {
               int x = i * columnWidth + columnWidth / 2;
               int y = 100;
               String date = String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH));
               g.drawString(date, x - g.getFontMetrics().stringWidth(date) / 2, y);
               tempCal.add(Calendar.DATE, 1);
           }
       }
   }

/**
 * Helper function to capitalize the first letter of a string
 * @param str- the string to capitalize
 * @return str- the capitalized string
 */
   private String capitalize(String str) {
       if (str == null || str.isEmpty()) return str;
       return str.substring(0, 1).toUpperCase() + str.substring(1);
   }
/**
 * Main method to run the WeeklyCalendar program
 * @param args- main method arguments
 */
   public static void main(String[] args) {
       // You can change the role here to test access control (e.g., "nurse", "volunteer")
       new WeeklyCalendar("accountType", "firstName", "lastName", "timeSlot");
   }
}