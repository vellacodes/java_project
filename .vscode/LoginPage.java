//for the login page graphics, we used example code from stackoverflow.com

//imports for all the graphics, buttons, and readers we may need
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.*;
import java.nio.Buffer;

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
        
        /**
         *
         * @Main Page, IGNORE-----------------------------------------------------------------------------------------------------------------
         */
        
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
        //Coding Part of LOGIN button
        //getting text entered by the user
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            //change to cycle through the CSV file to find username and password.
            
            //cycle through CSV file usernames.
            String file = "vscode\\users.csv";//file path to csv file
            BufferedReader reader = null;//BufferedReader to read the file
            String line = "";
            try{
                reader = new BufferedReader(new FileReader(file));
                while((line = reader.readLine()) != null){
                    //need to set employee info to the entire line, THEN split it by commas to get user, pass, and role
                    
                    String[] employee[i] = line.split(",");//splits strings into array of strings based on commas
                    for(String index : employee){
                        System.out.printf("%10s", index); //print out the index of the row to see if it works
                    }
                }
            } catch(Exception ex){
                System.out.println(ex);//displays what exactly went wrong
            }
            finally{
                try{
                reader.close();//close reader.
                } catch(Exception exe){
                    System.out.println(exe);//displays what went wrong
                }
            }
                Employee[] employees = line.split(","); //separates wherever there is a comma, splits data into array of strings to access easier
                ArrayList<String> employees = new ArrayList <String>(); //from employee class? List of role, user, and pass
                Employee e = newEmployee(userInfo(0), userInfo(1), userInfo(2));
                users.append(e); //add new employee to array list, can use for new users or remove to fire people.
                //After ending program (closing) write n

            /*if(username is found) something like employee[i](userInfo[0]) = input from username)
            then check if CORRESPONDING password is correct.- employee[i](userInfo[1]) = input from password
            then get role from employee[i](userInfo[2]) and take to page based on role.
            //if not found, then show message that username or password is incorrect.
            */

            //for loop 
            //if employyee[i]userInfo[0] = username input(
            //if employee[i]userInfo[1] = password input)
            //take to page


            /*
            array list of employee objects
            
            
            loop through csv file
            //read line into some variable
            string array split on commas\
            creates a size array of strings 
            read line one before loop b/.c not a person

            */
            for(int i = 0; i < employees.size(); i++){
                if(userText.equalsIgnoreCase(employee[i].userInfo[0])){
                    if(pwdText.equalsIgnoreCase(employee[i].userInfo[1])){
                        //log in and find role
                    }else{
                        JOptionPane.showMessageDialog("Invalid Password");
                    }
                JOptionPane.showMessageDialog("Invalid Username");
                }
            }

            }


            if (userText.equalsIgnoreCase("Admin") && pwdText.equalsIgnoreCase("Admin")) {
                JOptionPane.showMessageDialog(this, "Login Successful."+" Hello "+userText);
            } 
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
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