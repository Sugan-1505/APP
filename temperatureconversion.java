class Temperature {
    double celsius;
    void convertTemperature() {
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature Details");
        System.out.println("Celsius    : " + celsius + " °C");
        System.out.println("Fahrenheit : " + fahrenheit + " °F");
    }
    public static void main(String[] args) {
        Temperature t1 = new Temperature();
        t1.celsius = 25;
        t1.convertTemperature();
    }
}
