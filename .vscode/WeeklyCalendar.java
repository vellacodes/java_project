//this is code for the calendar and sign ups for time slots on the weekly schedule
//ameya and vella 5/6/2025

import java.awt.*;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JFrame;

public class WeeklyCalendar extends Frame {

   private Calendar calendar;
   private int dayOfWeek;

   public WeeklyCalendar() {
       super("Scheduling");
      
       calendar = Calendar.getInstance();
       dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

       Canvas canvas = new CalendarCanvas();
       add(canvas);

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
               int headingX = width/2;
          
               g.drawString(heading, headingX - g.getFontMetrics().stringWidth(heading) / 2, yheader);
               g.drawLine(0, ydivider, width, ydivider);
               g.drawString(daysOfWeek[i+1], x - g.getFontMetrics().stringWidth(daysOfWeek[i+1]) / 2, yweek);
               g.drawLine(i * columnWidth, 50, i * columnWidth, height);
              
           }
           g.drawLine(width-1, 50, width-1, height);

           // Draw dates
            Calendar tempCal = (Calendar) calendar.clone();
            tempCal.add(Calendar.DATE, -(dayOfWeek - tempCal.getFirstDayOfWeek()));

           for (int i = 0; i < 7; i++) {
               int x = i * columnWidth + columnWidth / 2;
               int y = 100;
               g.drawString(String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH)), x - g.getFontMetrics().stringWidth(String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH))) / 2, y);
               tempCal.add(Calendar.DATE, 1);
           }
       }
   }


   public static void main(String[] args) {
       new WeeklyCalendar();
   }
}

