/**
 * This is the WelcomePage class, which is the first page that the user sees when they open the application.
 * @author Vella and Ameya
 * @version 5/19/25
 */

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;// import JOptionPane
import java.awt.*;//import AWT graphics
import javax.swing.JLabel;//import JLabel

//code for joption pane pop-up window
//gives user option to log in or sign up
public class WelcomePage extends JFrame{
    private JFrame frame; //main frame

    /**
     * Creates the WelcomePage frame with a background image
     */
    public WelcomePage(){
        /*JFrame*/ 
        frame = new JFrame();
        frame.setTitle("Background");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel(/*new ImageIcon("test.png")*/" "));
        frame.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        frame.setVisible(true); //the main frame
    }
    /**
     * Main method to run the WelcomePage, includes pop up with options for login/sign up. Takes user to appropriate page based on user choice
     * @param args - main method arguments
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            new WelcomePage();
        });
        Object [] options = {"Log in to saved account", "Sign up to create new account"};
        //first pop-up window to ask user to log in or sign up
        int signIn = JOptionPane.showOptionDialog(null, "Log in or sign up to access", "Welcome to our hospital page!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        //takes user to different page based on their choice
        if( signIn == JOptionPane.YES_OPTION){
            //sends user to login page if they choose to log in
                EventQueue.invokeLater(() -> {
                    new LoginPage().login();
                });
        }else if( signIn== JOptionPane.NO_OPTION){
            //sends user to sign up page if they choose to sign up
                EventQueue.invokeLater(() -> {
                    new SigninPage().signin();
                });
        }else{
            //error message if user closes the pop-up window or clicks cancel
            JOptionPane.showMessageDialog(null, "No option selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}