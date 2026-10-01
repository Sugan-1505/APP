import javax.swing.*;
import java.awt.*;

class EmployeeModel {
    private String password = "admin123";

    public boolean validateLogin(String username, String enteredPassword) {
        return username.equals("admin") && enteredPassword.equals(password);
    }

    public boolean changePassword(String oldPassword, String newPassword, String confirmPassword) {
        if (!password.equals(oldPassword)) return false;
        if (!newPassword.equals(confirmPassword) || newPassword.isEmpty()) return false;
        password = newPassword;
        return true;
    }
}

class EmployeeView extends JFrame {
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton login = new JButton("Login");

    EmployeeView() {
        setTitle("Employee Management - Login");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 8, 8));
        add(new JLabel("Username:")); add(username);
        add(new JLabel("Password:")); add(password);
        add(new JLabel()); add(login);
    }
}

class MainView extends JFrame {
    JMenuItem addEmployee = new JMenuItem("Add Employee");
    JMenuItem viewEmployee = new JMenuItem("View Employee");
    JMenuItem changePassword = new JMenuItem("Change Password");
    JMenuItem logout = new JMenuItem("Logout");
    JMenuItem exit = new JMenuItem("Exit Application");

    MainView() {
        setTitle("Employee Management Portal");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar bar = new JMenuBar();
        JMenu employee = new JMenu("Employee");
        employee.add(addEmployee);
        employee.add(viewEmployee);

        JMenu tools = new JMenu("Tools");
        tools.add(changePassword);

        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logout);
        exitMenu.add(exit);

        bar.add(employee);
        bar.add(tools);
        bar.add(exitMenu);
        setJMenuBar(bar);
    }
}

public class EmployeeManagementPortalMVC {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeModel model = new EmployeeModel();
            EmployeeView loginView = new EmployeeView();

            loginView.login.addActionListener(e -> {
                String user = loginView.username.getText();
                String pass = new String(loginView.password.getPassword());

                if (model.validateLogin(user, pass)) {
                    loginView.dispose();
                    MainView mainView = new MainView();

                    mainView.addEmployee.addActionListener(x -> {
                        JTextField id = new JTextField();
                        JTextField name = new JTextField();
                        JTextField dept = new JTextField();
                        Object[] fields = {"Employee ID:", id, "Employee Name:", name, "Department:", dept};
                        int result = JOptionPane.showConfirmDialog(mainView, fields,
                                "Add Employee", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION)
                            JOptionPane.showMessageDialog(mainView, "Employee added successfully.");
                    });

                    mainView.viewEmployee.addActionListener(x ->
                            JOptionPane.showMessageDialog(mainView, "Employee records can be displayed here."));

                    mainView.changePassword.addActionListener(x -> {
                        JPasswordField oldP = new JPasswordField();
                        JPasswordField newP = new JPasswordField();
                        JPasswordField confirmP = new JPasswordField();
                        Object[] fields = {"Old Password:", oldP, "New Password:", newP,
                                "Confirm Password:", confirmP};
                        int result = JOptionPane.showConfirmDialog(mainView, fields,
                                "Change Password", JOptionPane.OK_CANCEL_OPTION);

                        if (result == JOptionPane.OK_OPTION) {
                            boolean changed = model.changePassword(
                                    new String(oldP.getPassword()),
                                    new String(newP.getPassword()),
                                    new String(confirmP.getPassword()));
                            JOptionPane.showMessageDialog(mainView,
                                    changed ? "Password changed successfully." :
                                    "Invalid old password or passwords do not match.");
                        }
                    });

                    mainView.logout.addActionListener(x -> {
                        mainView.dispose();
                        loginView.setVisible(true);
                    });

                    mainView.exit.addActionListener(x -> System.exit(0));
                    mainView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginView, "Invalid username or password.");
                }
            });

            loginView.setVisible(true);
        });
    }
}