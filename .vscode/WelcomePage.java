import javax.swing.JOptionPane;// import JOptionPane
import java.awt.*;//import AWT graphics

//code for joption pane pop-up window
//gives user option to log in or sign up
public class WelcomePage{
    public static void main(String[] args){
        Object [] options = {"Log in to saved account", "Sign up to create new account"};
        //first pop-up window to ask user to log in or sign up
        int signIn = JOptionPane.showOptionDialog(null, "Log in or sign up to access", "Sign In page", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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