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
    private JLabel timeLabel;
    private JLabel hoursLabel;
    private JLabel totalLabel;

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
        timeLabel = new JLabel("Time(s):");
        hoursLabel = new JLabel("Hours Worked:");
        totalLabel = new JLabel("Total:");
        /* 
        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = new String(passwordField.getPassword());
            System.out.println(userText + " " + pwdText); //for testing purposes
            ArrayList<Employee> employees = new ArrayList<Employee>(); //from employee class- List of role, user, and pass
            
            loop through csv file
            //read line into some variable
            string array split on commas\
            creates a size array of strings 
            read line one before loop b/.c not a person
            
            //looping through the csv file
           try{
                File file = new File("users.csv"); //create a file object to read the csv file
                Scanner reader = new Scanner(file);
                String line = reader.nextLine();
                while(reader.hasNextLine()){ //while there is a next line in the file
                    line = reader.nextLine(); //read the next line of the file
                    String[] userData = line.split(","); //splits strings into array of strings based on commas\
                    employees.add(new Employee(userData[0], userData[1], userData[2], userData[3], userData[4])); //add new employee to array list with user, pass, role, first name, and last name
                } reader.close();
           }catch(FileNotFoundException ex){
                System.out.println("File not found"); //if file is not found, print error message
           }
        }
*/
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
        lframe.setBounds(725,245,500,500);
        titleLabel.setBounds(20, 20, 250, 30);//WORK ON THIS PLS
        dayLabel.setBounds(20, 100, 100, 30);
        timeLabel.setBounds(180, 100, 150, 30);
        hoursLabel.setBounds(340, 100, 150, 30);
        totalLabel.setBounds(315, 250, 150, 30);
        backButton.setBounds(20, 400, 150, 30);
    }
/**
 * Adds all the components to the container
 */
    public void addComponentsToContainer() {
        container.add(titleLabel);
        container.add(dayLabel);
        container.add(timeLabel);
        container.add(hoursLabel);
        container.add(totalLabel);
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