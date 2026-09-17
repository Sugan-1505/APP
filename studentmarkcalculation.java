class Marks {
    int subject1;
    int subject2;
    int subject3;
    void calculate() {
        int total = subject1 + subject2 + subject3;
        double average = total / 3.0;
        System.out.println("Marks Details");
        System.out.println("Subject 1 : " + subject1);
        System.out.println("Subject 2 : " + subject2);
        System.out.println("Subject 3 : " + subject3);
        System.out.println("Total Marks : " + total);
        System.out.println("Average Marks : " + average);
    }
    public static void main(String[] args) {
        Marks m1 = new Marks();
        m1.subject1 = 85;
        m1.subject2 = 90;
        m1.subject3 = 80;
        m1.calculate();
    }
}
