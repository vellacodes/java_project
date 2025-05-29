/**
 * This displays the hours (both worked and scheduled) on a personalized page for the user
 * @author Vella and Ameya
 * @version 5/23/25
 */

//imports for all the graphics, buttons, and readers we may need
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;
/**
 * This is the LoginPage class, which is the page that the user sees when they choose to log in to an existing account.
 */
public class HoursPage extends JFrame implements ActionListener{

    private JFrame frame; //main frame
    private JFrame lframe; //login frame
    private Container container;
    private JLabel titleLabel;
    private JLabel dayLabel;
    private JLabel hoursLabel;
    private JLabel totalLabel;
    private JLabel lineLabel;
    private JLabel line2Label;
    private JLabel day1;
    private JLabel day2;
    private JLabel day3;   
    private JLabel day4;
    private JLabel day5;
    private JLabel day6;
    private JLabel day7;    

    private JButton backButton;
    private final String ACCOUNT; //the account type of the user
    private final String FIRSTNAME; //the first name of the user
    private final String LASTNAME; //the last name of the user

/**
 * Starting AWT graphics for LoginPage class.
 */
    public HoursPage(String accountType, String firstName, String lastName) {
        ACCOUNT = accountType;
        FIRSTNAME = firstName;
        LASTNAME = lastName;

        container = getContentPane();
        titleLabel = new JLabel(accountType + " " + firstName + " " + lastName + "- Hours Served:");
        dayLabel = new JLabel("Day:");
        hoursLabel = new JLabel("Hours Worked:");
        totalLabel = new JLabel("Total:");
        lineLabel = new JLabel("------------------------------------------------------------------------------------------------------------");
        line2Label = new JLabel("--------------------------------");

        int totalHours = 0; //initialize total hours to 0 
        int sunTotalHours = 0;
        int monTotalHours = 0;
        int tueTotalHours = 0;
        int wedTotalHours = 0;
        int thuTotalHours = 0;
        int friTotalHours = 0;
        int satTotalHours = 0;          
           try{
                File file = new File("timeSlots.csv"); //create a file object to read the csv file
                Scanner reader = new Scanner(file);
                String line = reader.nextLine();
                while(reader.hasNextLine()){ //while there is a next line in the file
                    line = reader.nextLine(); //read the next line of the file
                    String[] parts = line.split(","); //split the line by commas
                    String name = parts[0]; //the first part is the name of the user
                    String day = parts[1]; //the second part is the day of the week

                    
                    if(name.equalsIgnoreCase(FIRSTNAME)){
                        if(day.equalsIgnoreCase("sun")){
                            sunTotalHours = sunTotalHours + 2;
                        }else if(day.equalsIgnoreCase("mon")){
                            monTotalHours = monTotalHours + 2;
                        }else if(day.equalsIgnoreCase("tue")){
                            tueTotalHours = tueTotalHours + 2;
                        }else if(day.equalsIgnoreCase("wed")){
                            wedTotalHours = wedTotalHours + 2;
                        }else if(day.equalsIgnoreCase("thu")){  
                            thuTotalHours = thuTotalHours + 2;
                        }else if(day.equalsIgnoreCase("fri")){
                            friTotalHours = friTotalHours + 2;
                        }else if(day.equalsIgnoreCase("sat")){
                            satTotalHours = satTotalHours + 2;
                        }
                    }
                    
                } reader.close();
           }catch(FileNotFoundException ex){
                System.out.println("File not found"); //if file is not found, print error message
           }
        totalHours = sunTotalHours + monTotalHours + tueTotalHours + wedTotalHours + thuTotalHours + friTotalHours + satTotalHours; //calculate total hours worked by the user

        day1 = new JLabel("Sunday" + "                             " + sunTotalHours + " hours");
        day2 = new JLabel("Monday" + "                          " + monTotalHours + " hours");
        day3 = new JLabel("Tuesday" + "                       " + tueTotalHours + " hours");
        day4 = new JLabel("Wednesday" + "                 " + wedTotalHours + " hours");
        day5 = new JLabel("Thursday" + "                      " + thuTotalHours + " hours");
        day6 = new JLabel("Friday" + "                        " + friTotalHours + " hours");
        day7 = new JLabel("Saturday" + "                      " + satTotalHours + " hours");
        totalLabel = new JLabel("Total: \n" + totalHours + " hours");
        backButton = new JButton("Back To Calendar");
        /*JFrame*/ lframe=new JFrame();
        container = lframe.getContentPane();
        lframe.setTitle("Hours:");

        /*JFrame*/ frame = new JFrame();
        frame.setTitle("Background");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel(/*new ImageIcon("test.png")*/" "));
        frame.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true); //the main frame
        lframe.setVisible(true); //if the login is successful then the main frame is visible
    }
/**
 * Calls methods to create login page
 */
    public void hoursDisplay() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        lframe.setVisible(true);
    }
/**
 * Sets layout manager for login page
 */
    public void setLayoutManager() {
        container.setLayout(null);
    }
 /**
  * Sets the location and size of all the components on the login page
  */
    public void setLocationAndSize() {
        lframe.setBounds(725,245,400,600);
        titleLabel.setBounds(20, 20, 250, 30);//WORK ON THIS PLS
        dayLabel.setBounds(20, 75, 100, 30);
        hoursLabel.setBounds(150, 75, 150, 30);
        totalLabel.setBounds(330, 360, 150, 30);
        lineLabel.setBounds(20, 85, 700, 30);
        line2Label.setBounds(320, 350, 700, 30);
        backButton.setBounds(20, 450, 150, 30);
        day1.setBounds(20, 100, 300, 30);
        day2.setBounds(20, 140, 300, 30);
        day3.setBounds(20, 180, 300, 30);
        day4.setBounds(20, 220, 300, 30);
        day5.setBounds(20, 260, 300, 30);
        day6.setBounds(20, 300, 300, 30);
        day7.setBounds(20, 340, 300, 30);
    }
/**
 * Adds all the components to the container
 */
    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(dayLabel);
        container.add(hoursLabel);
        container.add(totalLabel);
        container.add(lineLabel);
        container.add(line2Label);
        container.add(day1);
        container.add(day2);
        container.add(day3);
        container.add(day4);
        container.add(day5);
        container.add(day6);
        container.add(day7);
        container.add(backButton);
        
        JLabel lblNewLabel = new JLabel("test1.png");
//        lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/development/test1.png")));
        lblNewLabel.setBounds(106, 10, 204, 113);
        getContentPane().add(lblNewLabel);
    }
/**
 * Code for button
 */
    public void addActionEvent() {
        backButton.addActionListener(this);
    }
/**
 * Action performed method for all the buttons and checkboxes
 * @param e - action event, which button was pressed
 */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            // If the back button is pressed, go back to the calendar page
            WeeklyCalendar calendar = new WeeklyCalendar(ACCOUNT,FIRSTNAME,LASTNAME); //create a new instance of the WeeklyCalendar class
        }
    }
    /**
     * Main method to run the HoursPage
     * @param args - main method arguments
     */
    public static void main(String[] args) {
        // You can change the role here to test access control (e.g., "nurse", "volunteer")
        String accountType = "Nurse"; // Example account type
        String firstName = "John"; // Example first name
        String lastName = "Doe"; // Example last name
        new HoursPage(accountType, firstName, lastName).hoursDisplay();
    }
}