/**
 * Login Page, displays a login page for the user to enter their username and password. for the login page graphics, we used example code from stackoverflow.com
 * @author Vella and Ameya
 * @version 5/19/25 
*/

//imports for all the graphics, buttons, and readers we may need
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * This is the LoginPage class, which is the page that the user sees when they choose to log in to an existing account.
 */
public class LoginPage extends JFrame implements ActionListener{

    private JFrame frame; //main frame
    private JFrame lframe; //login frame
    private Container container;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetButton;
    private JCheckBox showPassword;

    private String userText = ""; // Declare userText as an instance variable
    private String pwdText = "";  // Declare pwdText as an instance variable

/**
 * Starting AWT graphics for LoginPage class.
 */
    public LoginPage() {
        container = getContentPane();
        userLabel = new JLabel("USERNAME");
        passwordLabel = new JLabel("PASSWORD");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");
        /*JFrame*/ lframe=new JFrame();
        container = lframe.getContentPane();
        lframe.setTitle("Login:");

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
    public void login() {
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
        userLabel.setBounds(120, 140, 100, 30);
        passwordLabel.setBounds(120, 210, 100, 30);
        userTextField.setBounds(220, 140, 150, 30);
        passwordField.setBounds(220, 210, 150, 30);
        showPassword.setBounds(220, 250, 150, 30);
        loginButton.setBounds(115, 300, 100, 30);
        resetButton.setBounds(265, 300, 100, 30);
    }
/**
 * Adds all the components to the container
 */
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        
        JLabel lblNewLabel = new JLabel("test1.png");
//        lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/development/test1.png")));
        lblNewLabel.setBounds(106, 10, 204, 113);
        getContentPane().add(lblNewLabel);
    }
/**
 * Code for buttons and checkboxes
 */
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
/**
 * Action performed method for all the buttons and checkboxes
 * @param e - action event, which button was pressed
 */
    public void actionPerformed(ActionEvent e) {
            userText = "";
            pwdText = "";
        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = new String(passwordField.getPassword());
            System.out.println(userText + " " + pwdText); //for testing purposes
        ArrayList<Employee> employees = new ArrayList<Employee>(); //from employee class- List of role, user, and pass
            /*
            loop through csv file
            //read line into some variable
            string array split on commas\
            creates a size array of strings 
            read line one before loop b/.c not a person
            */
            //looping through the csv file
           try{
                File file = new File("users.csv"); //create a file object to read the csv file
                Scanner reader = new Scanner(file);
                String line = reader.nextLine();
                while(reader.hasNextLine()){ //while there is a next line in the file
                    line = reader.nextLine(); //read the next line of the file
                    String[] userData = line.split(","); //splits strings into array of strings based on commas\
                    employees.add(new Employee(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5], userData[6])); //add new employee to array list with user, pass, role, first name, and last name
                } reader.close();
           }catch(FileNotFoundException ex){
                System.out.println("File not found"); //if file is not found, print error message
           }
            //looping through array list of employees
            for(Employee emp : employees){
                if(emp.getUsername().equals(userText)){
                    if(emp.getPassword().equals(pwdText)){
                        //log into role
                        JOptionPane.showMessageDialog(this, "Welcome " + emp.getRole() + " " + emp.getName() + " " + emp.getLastName()); //if username and password are correct, show welcome message
                        if(emp.getRole().equalsIgnoreCase("doctor")){
                            //send to doctor page
                            new WeeklyCalendar(emp.getRole(), emp.getName(), emp.getLastName(), emp.getTime()); //send to doctor page
                        }else if(emp.getRole().equalsIgnoreCase("nurse")){
                            //send to nurse page
                            new WeeklyCalendar(emp.getRole(), emp.getName(), emp.getLastName(), emp.getTime()); //send to nurse page
                        }else if(emp.getRole().equalsIgnoreCase("volunteer")){
                            //send to volunteer page
                            new WeeklyCalendar(emp.getRole(), emp.getName(), emp.getLastName(), emp.getTime()); //send to volunteer page
                        }else if(emp.getRole().equalsIgnoreCase("staff")){
                            //send to personel page
                            new WeeklyCalendar(emp.getRole(), emp.getName(), emp.getLastName(), emp.getTime()); //send to staff page
                        }
                        break;
                    }else{
                        //if password is incorrect, show error message
                        JOptionPane.showMessageDialog(this, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }else{
                }
            }
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }        
    }
}