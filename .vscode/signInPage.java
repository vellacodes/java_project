import java.util.*;//import scanner
import javax.swing.JOptionPane;// import JOptionPane
import java.awt.*;//import AWT graphics
import java.awt.event.*;


public class signInPage{
    public static void main(String[] args){
        Object [] options = {"Log in to saved account", "Sign up to create new account"};
        //first pop-up window to ask user to log in or sign up
        int signIn = JOptionPane.showOptionDialog(null, "Log in or sign up to access", "Sign In page", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        //takes user to different page based on their choice
        if( signIn == JOptionPane.YES_OPTION){
            //code for log in page
                EventQueue.invokeLater(() -> {
                    new TestFrame().login();
                });
        }else if( signIn== JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Sign up to create new account", "Sign up", JOptionPane.INFORMATION_MESSAGE);
            //code for sign up page
            
        }else{
            //error message if user closes the pop-up window or clicks cancel
            JOptionPane.showMessageDialog(null, "No option selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}