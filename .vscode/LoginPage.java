import java.awt.*;
import java.awt.event.*;

public class LoginPage extends Frame implements ActionListener {
    private Label usernameLabel, passwordLabel, messageLabel;
    private TextField usernameText;
    private PasswordField passwordText;
    private Button loginButton;

    public LoginPage() {
        setTitle("Login Page");
        setSize(300, 200);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        usernameLabel = new Label("Username");
        usernameText = new TextField(20);
        passwordLabel = new Label("Password");
        passwordText = new PasswordField(20);
        loginButton = new Button("Login");
        loginButton.addActionListener(this);
        messageLabel = new Label("");

        add(usernameLabel);
        add(usernameText);
        add(passwordLabel);
        add(passwordText);
        add(loginButton);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = usernameText.getText();
        String password = new String(passwordText.getPassword());

        if (username.equals("user") && password.equals("password")) {
            messageLabel.setText("Login Successful");
        } else {
            messageLabel.setText("Login Failed");
        }
    }
    public static void main(String[] args) {
        new LoginPage();
    }
}