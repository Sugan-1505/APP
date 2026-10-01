import javax.swing.*;
import java.awt.*;

public class UserLoginPreferences extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberMe, notifications;

    public UserLoginPreferences() {
        setTitle("User Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");
        add(rememberMe);
        add(notifications);

        JButton login = new JButton("Login");
        add(new JLabel());
        add(login);

        login.addActionListener(e -> {
            String username = usernameField.getText();
            boolean remember = rememberMe.isSelected();
            boolean notify = notifications.isSelected();

            JOptionPane.showMessageDialog(this,
                    "Login successful for: " + username +
                    "\nRemember Me: " + remember +
                    "\nNotifications: " + notify);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserLoginPreferences::new);
    }
}