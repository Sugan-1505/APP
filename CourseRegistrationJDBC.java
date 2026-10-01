import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sql = "SELECT StudentID, StudentName, CourseCode, CourseName, Semester "
                   + "FROM CourseRegistration WHERE CourseCode=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();
            ps.setString(1, courseCode);

            try (ResultSet rs = ps.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.println("Student ID: " + rs.getInt("StudentID"));
                    System.out.println("Student Name: " + rs.getString("StudentName"));
                    System.out.println("Course Code: " + rs.getString("CourseCode"));
                    System.out.println("Course Name: " + rs.getString("CourseName"));
                    System.out.println("Semester: " + rs.getString("Semester"));
                    System.out.println("---------------------------");
                }
                if (!found)
                    System.out.println("No students are registered for this course code.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}