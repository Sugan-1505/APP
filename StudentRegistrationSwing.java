import javax.swing.*;
import java.awt.*;

public class StudentRegistrationSwing extends JFrame {
    private JTextField nameField, registerField;
    private JRadioButton male, female, other;
    private JComboBox<String> department;

    public StudentRegistrationSwing() {
        setTitle("Student Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Register Number:"));
        registerField = new JTextField();
        add(registerField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        group.add(male); group.add(female); group.add(other);
        genderPanel.add(male); genderPanel.add(female); genderPanel.add(other);
        add(genderPanel);

        add(new JLabel("Department:"));
        department = new JComboBox<>(new String[]{"CSE", "IT", "ECE", "EEE", "MECH"});
        add(department);

        JButton submit = new JButton("Submit");
        add(new JLabel());
        add(submit);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" :
                            other.isSelected() ? "Other" : "Not selected";
            JOptionPane.showMessageDialog(this,
                    "Name: " + nameField.getText() +
                    "\nRegister No: " + registerField.getText() +
                    "\nGender: " + gender +
                    "\nDepartment: " + department.getSelectedItem());
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistrationSwing::new);
    }
}