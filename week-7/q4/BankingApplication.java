package q4;

class BankingTask implements Runnable {
    private final String activity;
    private final int delay;
    BankingTask(String activity, int delay) { this.activity = activity; this.delay = delay; }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + activity + " - Execution " + i);
            try { Thread.sleep(delay); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        Thread transaction = new Thread(new BankingTask("Processing transaction", 1000));
        Thread balance = new Thread(new BankingTask("Updating balance", 1500));
        Thread sms = new Thread(new BankingTask("Sending SMS notification", 2000));
        transaction.setName("Transaction Thread");
        balance.setName("Balance Thread");
        sms.setName("SMS Thread");
        transaction.start(); balance.start(); sms.start();
    }
}
