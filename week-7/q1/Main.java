package q1;

import q1.student.Student;
import q1.course.Course;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Sugan", "CSE");
        Course course = new Course("APP101", "Advanced Programming Practice", 4);

        System.out.println("--- Student Details ---");
        student.displayStudent();

        System.out.println("\n--- Course Details ---");
        course.displayCourse();
    }
}
