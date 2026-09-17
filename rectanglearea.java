class Rectangle {
    double length;
    double breadth;
    void calculateArea() {
        double area = length * breadth;
        System.out.println("Rectangle Details");
        System.out.println("Length  : " + length);
        System.out.println("Breadth : " + breadth);
        System.out.println("Area    : " + area);
    }
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.length = 12.5;
        r1.breadth = 8.0;
        r1.calculateArea();
    }
}
