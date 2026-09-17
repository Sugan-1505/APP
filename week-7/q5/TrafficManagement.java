package q5;

class Junction extends Thread {
    private final String trafficStatus;
    private final int delay;
    Junction(String trafficStatus, int delay) { this.trafficStatus = trafficStatus; this.delay = delay; }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: " + trafficStatus + " - Report " + i);
            try { Thread.sleep(delay); } catch (InterruptedException e) { interrupt(); }
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) {
        Junction j1 = new Junction("Heavy Traffic", 1000);
        Junction j2 = new Junction("Moderate Traffic", 1500);
        Junction j3 = new Junction("Light Traffic", 2000);
        j1.setName("Junction 1");
        j2.setName("Junction 2");
        j3.setName("Junction 3");
        j1.start(); j2.start(); j3.start();
    }
}
