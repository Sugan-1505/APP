class Student {
    String name;
    int age;
    void display() {
        System.out.println("Student Name : " + name);
        System.out.println("Student Age  : " + age);
        System.out.println();
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Pravin";
        s1.age = 18;
        Student s2 = new Student();
        s2.name = "Rahul";
        s2.age = 19;
        System.out.println("Student 1 Details");
        s1.display();
        System.out.println("Student 2 Details");
        s2.display();
    }
}
