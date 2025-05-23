/**
 * Displays the sign in page after welcome page choice. Example graphics code from stackoverflow.com
 * @author Vella and Ameya
 * @version 1.0
 */

//imports for all the graphics, buttons, and readers we may need
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * This is the SigninPage class, which is the page that the user sees when they choose to sign up for a new account.
 */
    public class SigninPage extends JFrame implements ActionListener{

    private JFrame frame; //main frame
    private JFrame lframe; //login frame
    //graphics variables
    private Container container;
    //labels for the text fields
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel password2Label;
    private JLabel roleLabel;
    //text fields for the user to input their information
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JPasswordField password2Field;
    private JTextField roleField;

    private JButton createButton;
    private JButton resetButton;
    private JCheckBox showPassword;

    private String firstName = ""; // firstName instance variable
    private String lastName = ""; // lastName instance variable
    private String role = ""; // Declare role as an instance variable
    private String userText = ""; // Declare userText as an instance variable
    private String pwdText = "";// Declare pwdText as an instance variable
    private String pwd2Text = ""; // Declare pwd2Text as an instance variable (for double password check)


    /**
     * Starting AWT graphics for SigninPage class.
     */
    public SigninPage() {
//      assign labels
        firstNameLabel = new JLabel("FIRST NAME:");
        lastNameLabel = new JLabel("LAST NAME:");
        roleLabel = new JLabel("ROLE:");
        userLabel = new JLabel("CREATE USERNAME:");
        passwordLabel = new JLabel("PASSWORD:");
        password2Label = new JLabel("COMFIRM PASSWORD:");
        

        //assign text fields
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        roleField = new JTextField();
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        password2Field = new JPasswordField();
        //assign buttons
        createButton = new JButton("CREATE ACCOUNT");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");
        /*JFrame*/ lframe=new JFrame();
        container = lframe.getContentPane(); 
        lframe.setTitle("Sign Up Page:");

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
 * Calls all the methods to create the sign in page
 */
    public void signin() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        lframe.setVisible(true);
    }
/**
 * Sets the layout manager for the sign in page
 */
    public void setLayoutManager() {
        container.setLayout(null);
    }
 /**
  * Sets the location and size of the components on the sign in page
  */
    public void setLocationAndSize() {
        //set the size of the text fields and buttons
        lframe.setBounds(700,300,500,500);

        firstNameLabel.setBounds(50, 50, 100, 30);
        lastNameLabel.setBounds(50, 100, 100, 30);
        roleLabel.setBounds(50, 150, 100, 30);
        userLabel.setBounds(50, 200, 150, 30);
        passwordLabel.setBounds(50, 250, 100, 30);
        password2Label.setBounds(50, 300, 150, 30);

        firstNameField.setBounds(200, 50, 150, 30);
        lastNameField.setBounds(200, 100, 150, 30);
        roleField.setBounds(200, 150, 150, 30);
        userTextField.setBounds(200, 200, 150, 30);
        passwordField.setBounds(200, 250, 150, 30);
        password2Field.setBounds(200, 300, 150, 30);

        showPassword.setBounds(150, 350, 150, 30);
        createButton.setBounds(75, 400, 150, 30);
        resetButton.setBounds(275, 400, 100, 30);
    }
 /**
  * Adds all the components to the container
  */
    public void addComponentsToContainer() {
        container.add(firstNameLabel);
        container.add(lastNameLabel);
        container.add(roleLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(password2Label);

        container.add(firstNameField);
        container.add(lastNameField);
        container.add(roleField);
        container.add(userTextField);
        container.add(passwordField);
        container.add(password2Field);

        container.add(showPassword);
        container.add(createButton);
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
        createButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
/**
 * What occurs when buttons are pressed, including creating account, adding to fields, and displaying password
 * @param e - action, which button was pressed
 */
    public void actionPerformed(ActionEvent e) {
            firstName = "";
            lastName = "";
            userText = "";
            pwdText = "";
            pwd2Text = ""; 
            role = "";
        if (e.getSource() == createButton) {
            //geting info from text fields
            firstName = firstNameField.getText();
            lastName = lastNameField.getText();
            role = roleField.getText(); 
            userText = userTextField.getText();
            pwdText = new String(passwordField.getPassword());
            pwd2Text = new String(password2Field.getPassword());
            if(!pwdText.equals(pwd2Text)){
                JOptionPane.showMessageDialog(this, "Passwords do not match"); //if passwords do not match, show error message
                return; //exit the method if passwords do not match
            }
            /*
            string array split on commas
            writes new user info into the csv file
            */
            //looping through the csv file
            try{
                FileWriter writer = new FileWriter("users.csv", true); //create a file writer to write to the csv file
                BufferedWriter bw = new BufferedWriter(writer); //create a buffered writer to write to the file
                PrintWriter pw = new PrintWriter(bw); //create a print writer to write to the file
                pw.println(userText + "," + pwdText + "," + role + "," + firstName + "," + lastName + ",date,time" ); //write the user info to the file
                System.out.println(userText + "," + pwdText + "," + role + "," + firstName + "," + lastName ); //for testing purposes
                pw.close(); //close the file writer
                JOptionPane.showMessageDialog(this, "Account Created Successfully. Welcome " + role + " " + firstName + " " + lastName); //show success message

                //when account created, send user to login page
                EventQueue.invokeLater(() -> {
                    new LoginPage().login(); //send user to login page
                });

            }catch(IOException ex){
                System.out.println("File not found"); //if file is not found, print error message
            }
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            firstNameField.setText("");
            lastNameField.setText("");
            roleField.setText("");
            userTextField.setText("");
            passwordField.setText("");
            password2Field.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
                password2Field.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
                password2Field.setEchoChar('*');
            }
        }        
    }
}