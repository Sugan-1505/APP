class Employee {
    int empId;
    String empName;
    double salary;
    void display() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary        : Rs." + salary);
        System.out.println();
    }
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.empId = 101;
        e1.empName = "Rahul";
        e1.salary = 35000;
        Employee e2 = new Employee();
        e2.empId = 102;
        e2.empName = "Priya";
        e2.salary = 42000;
        System.out.println("Employee 1 Details");
        e1.display();
        System.out.println("Employee 2 Details");
        e2.display();
    }
}
