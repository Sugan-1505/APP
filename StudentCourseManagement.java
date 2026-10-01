import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentCourseManagement extends JFrame {
    private JList<String> courseList;
    private DefaultTableModel model;

    public StudentCourseManagement() {
        setTitle("Student Course Management");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        courseList = new JList<>(new String[]{
            "Java Programming", "Data Structures", "Operating Systems",
            "Database Management", "Computer Networks"
        });

        model = new DefaultTableModel(
                new String[]{"Student Name", "Selected Course", "Enrollment Status"}, 0);
        JTable table = new JTable(model);

        JButton add = new JButton("Add Registration");
        JButton remove = new JButton("Remove Registration");

        add.addActionListener(e -> {
            String course = courseList.getSelectedValue();
            if (course != null) {
                model.addRow(new Object[]{"Student", course, "Enrolled"});
            }
        });

        remove.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) model.removeRow(row);
        });

        JPanel left = new JPanel(new BorderLayout());
        left.add(new JLabel("Available Courses"), BorderLayout.NORTH);
        left.add(new JScrollPane(courseList), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(remove);

        add(left, BorderLayout.WEST);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentCourseManagement::new);
    }
}