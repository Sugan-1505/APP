import javax.swing.*;
import java.awt.*;

class GradeModel {
    private String studentName;
    private int mark1, mark2, mark3;

    public void setDetails(String name, int m1, int m2, int m3) {
        studentName = name;
        mark1 = m1; mark2 = m2; mark3 = m3;
    }

    public int getTotal() { return mark1 + mark2 + mark3; }

    public double getAverage() { return getTotal() / 3.0; }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 50) return "D";
        return "F";
    }

    public String getStudentName() { return studentName; }
}

class GradeView extends JFrame {
    JTextField nameField = new JTextField();
    JTextField mark1Field = new JTextField();
    JTextField mark2Field = new JTextField();
    JTextField mark3Field = new JTextField();
    JButton calculateButton = new JButton("Calculate Result");

    GradeView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 8, 8));

        add(new JLabel("Student Name:")); add(nameField);
        add(new JLabel("Subject 1 Mark:")); add(mark1Field);
        add(new JLabel("Subject 2 Mark:")); add(mark2Field);
        add(new JLabel("Subject 3 Mark:")); add(mark3Field);
        add(new JLabel()); add(calculateButton);
    }
}

public class StudentGradeCalculatorMVC {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeModel model = new GradeModel();
            GradeView view = new GradeView();

            view.calculateButton.addActionListener(e -> {
                try {
                    model.setDetails(view.nameField.getText(),
                            Integer.parseInt(view.mark1Field.getText()),
                            Integer.parseInt(view.mark2Field.getText()),
                            Integer.parseInt(view.mark3Field.getText()));

                    JOptionPane.showMessageDialog(view,
                            "Name: " + model.getStudentName()
                            + "\nTotal: " + model.getTotal()
                            + "\nAverage: " + String.format("%.2f", model.getAverage())
                            + "\nGrade: " + model.getGrade());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Enter valid marks.");
                }
            });
            view.setVisible(true);
        });
    }
}