package q3;

class ExamTask implements Runnable {
    private final String activity;
    private final int delay;
    ExamTask(String activity, int delay) { this.activity = activity; this.delay = delay; }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + activity);
            try { Thread.sleep(delay); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Thread timer = new Thread(new ExamTask("Displaying remaining time", 1000));
        Thread autosave = new Thread(new ExamTask("Auto-saving student answers", 1500));
        Thread network = new Thread(new ExamTask("Checking network connection", 2000));
        timer.setName("Timer Thread");
        autosave.setName("AutoSave Thread");
        network.setName("Network Thread");
        timer.start(); autosave.start(); network.start();
    }
}
