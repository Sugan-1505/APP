package q1.student;

public class Student {
    private int studentId;
    private String name;
    private String department;

    public Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + name);
        System.out.println("Department: " + department);
    }
}
