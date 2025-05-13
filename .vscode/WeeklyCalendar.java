//this is code for the calendar and sign ups for time slots on the weekly schedule
//ameya and vella 5/6/2025

import java.awt.*;
import java.util.Calendar;
import java.util.Locale;

public class WeeklyCalendar extends Frame {

   private final Calendar calendar;
   private final Font font;

   public WeeklyCalendar() {
       setTitle("Weekly Calendar");
       setSize(600, 200);
       setVisible(true);
       addWindowListener(new java.awt.event.WindowAdapter() {
           @Override
           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
               System.exit(0);
           }
       });

       calendar = Calendar.getInstance();
       font = new Font("Arial", Font.PLAIN, 14);
   }

   @Override
   public void paint(Graphics g) {
       g.setFont(font);
       drawDaysOfWeek(g);
       drawDates(g);
   }

   private void drawDaysOfWeek(Graphics g) {
       String[] daysOfWeek = new String[7];
       Calendar tempCal = (Calendar) calendar.clone();

       tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());

       for (int i = 0; i < 7; i++) {
           daysOfWeek[i] = tempCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
           tempCal.add(Calendar.DATE, 1);
       }

       int x = 50;
       int y = 50;
       int xIncrement = 80;

       for (String day : daysOfWeek) {
           g.drawString(day, x, y);
           x += xIncrement;
       }
   }

   private void drawDates(Graphics g) {
       int x = 50;
       int y = 80;
       int xIncrement = 80;

       Calendar tempCal = (Calendar) calendar.clone();
       tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());

       for (int i = 0; i < 7; i++) {
           g.drawString(String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH)), x, y);
           tempCal.add(Calendar.DATE, 1);
           x += xIncrement;
       }
   }

   public static void main(String[] args) {
       new WeeklyCalendar();
   }
}






		

	














import java.awt.*;
import java.util.Calendar;
import java.util.Locale;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class WeeklyCalendar extends Frame {


   private Calendar calendar;
   private int dayOfWeek;


   public WeeklyCalendar() {
       super("Scheduling");


       calendar = Calendar.getInstance();
       dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


       // Use BorderLayout to place canvas and buttons
       setLayout(new BorderLayout());


       // Canvas for drawing calendar
       Canvas canvas = new CalendarCanvas();
       add(canvas, BorderLayout.CENTER);


       // Panel with 7 buttons
       Panel buttonPanel = new Panel();
       buttonPanel.setLayout(new GridLayout(1, 7));




       String[] daysOfWeek = new java.text.DateFormatSymbols(Locale.getDefault()).getShortWeekdays();


       for (int i = 1; i <= 7; i++) {  // daysOfWeek[1] = Sunday
           Button dayButton = new Button("Schedule " + daysOfWeek[i]);
           buttonPanel.add(dayButton);


int dayIndex = i;  // capture i for use inside lambda
dayButton.addActionListener(e -> {
   // Create a panel to hold buttons
   JPanel panel = new JPanel();
   panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


   JLabel label = new JLabel("Select the times you would like to schedule yourself:");
   panel.add(label);


   JButton btn1 = new JButton("8:00am - 10:00am");
   JButton btn2 = new JButton("10:00am - 12:00pm");
   JButton btn3 = new JButton("2:00pm - 5:00pm");


   panel.add(btn1);
   panel.add(btn2);
   panel.add(btn3);


   // Show panel in dialog
   JOptionPane.showMessageDialog(null, panel, "Select Time Slot", JOptionPane.PLAIN_MESSAGE);
});


           // You can add action listeners here if needed
           // dayButton.addActionListener(e -> System.out.println("Clicked " + daysOfWeek[i]));
       }


       add(buttonPanel, BorderLayout.SOUTH);


       setSize(600, 400);
       setVisible(true);
       addWindowListener(new java.awt.event.WindowAdapter() {
           public void windowClosing(java.awt.event.WindowEvent e) {
               dispose();
           }
       });
   }


   class CalendarCanvas extends Canvas {
       @Override
       public void paint(Graphics g) {
           int width = getWidth();
           int height = getHeight();
           int columnWidth = width / 7;


           String[] daysOfWeek = new java.text.DateFormatSymbols(Locale.getDefault()).getShortWeekdays();


           // Draw column headers
           for (int i = 0; i < 7; i++) {
               int x = i * columnWidth + columnWidth / 2;
               int yweek = 40;
               int yheader = 15;
               int ydivider = 50;
               String heading = "Welcome";
               int headingX = width / 2;


               g.drawString(heading, headingX - g.getFontMetrics().stringWidth(heading) / 2, yheader);
               g.drawLine(0, ydivider, width, ydivider);
               g.drawString(daysOfWeek[i + 1], x - g.getFontMetrics().stringWidth(daysOfWeek[i + 1]) / 2, yweek);
               g.drawLine(i * columnWidth, 50, i * columnWidth, height);
           }
           g.drawLine(width - 1, 50, width - 1, height);


           // Draw dates
           Calendar tempCal = (Calendar) calendar.clone();
           tempCal.add(Calendar.DATE, -(dayOfWeek - tempCal.getFirstDayOfWeek()));


           for (int i = 0; i < 7; i++) {
               int x = i * columnWidth + columnWidth / 2;
               int y = 100;
               g.drawString(String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH)),
                       x - g.getFontMetrics().stringWidth(String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH))) / 2, y);
               tempCal.add(Calendar.DATE, 1);
           }
       }
   }


   public static void main(String[] args) {
       new WeeklyCalendar();
   }
}