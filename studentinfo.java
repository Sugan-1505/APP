class Student {
    String name;
    int rollNumber;
    String department;
    void getDetails(String n, int r, String d) {
        name = n;
        rollNumber = r;
        department = d;
    }
    void displayDetails() {
        System.out.println("Student Details");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Department : " + department);
    }
        public static void main(String[] args) {
        Student s1 = new Student();
        s1.getDetails("Pravin", 001, "Computer Science");
        s1.displayDetails();
    }
}
