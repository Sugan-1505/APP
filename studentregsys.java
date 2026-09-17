class Student {
    String name;
    int rollNo;
    void display() {
        System.out.println("Student Details");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Pravin";
        s1.rollNo = 101;
        s1.display();
    }
}
