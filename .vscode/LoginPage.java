//for the login page graphics, we used example code from stackoverflow.com

//imports for all the graphics, buttons, and readers we may need
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

//creates graphics for new login page
    public LoginPage() {
//        container = getContentPane();
        userLabel = new JLabel("USERNAME");
        passwordLabel = new JLabel("PASSWORD");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");
        /*JFrame*/ lframe=new JFrame();
        container = lframe.getContentPane(); // ADDED this line
        lframe.setTitle("Login BHMS");

        /*JFrame*/ frame = new JFrame();
        frame.setTitle("Test System");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel(/*new ImageIcon("test.png")*/"test.png"));
        frame.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true); //the main frame
        lframe.setVisible(true); //if the login is successful then the main frame is visible
    }

    public void login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        lframe.setVisible(true);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        lframe.setBounds(500,500,500,500);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
    }
 
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
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
            userText = "";
            pwdText = "";
        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = new String(passwordField.getPassword());
        }
        ArrayList<Employee> employees = new ArrayList<Employee>(); //from employee class? List of role, user, and pass
            /*
            loop through csv file
            //read line into some variable
            string array split on commas\
            creates a size array of strings 
            read line one before loop b/.c not a person
            */
            //looping through the csv file
           try{
                File file = new File("vscode\\users.csv"); //create a file object to read the csv file
                Scanner reader = new Scanner(file);
                String line = reader.nextLine();
                while(reader.hasNextLine()){ //while there is a next line in the file
                    line = reader.nextLine(); //read the next line of the file
                    String[] userData = line.split(","); //splits strings into array of strings based on commas
                    employees.add(new Employee(userData[0], userData[1], userData[2])); //add new employee to array list with user, pass, and role
                } reader.close();
           }catch(FileNotFoundException ex){
                System.out.println("File not found"); //if file is not found, print error message
           }

            //looping through array list of employees
            for(Employee emp : employees){
                if(emp.getUsername().equals(userText)){
                    if(emp.getPassword().equals(pwdText)){
                        //log into role
                        JOptionPane.showMessageDialog(this, "yayyyyyy");
                    }else{
                        JOptionPane.showMessageDialog(this, "Invalid Password");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Invalid Username");
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