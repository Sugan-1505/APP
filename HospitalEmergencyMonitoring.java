class HospitalEmergencyMonitoring {
    static class EmergencyAlert extends Thread {
        EmergencyAlert() { super("EmergencyAlert"); }
        public void run() {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Critical patient alert");
        }
    }

    static class VitalMonitor extends Thread {
        VitalMonitor() { super("VitalMonitor"); }
        public void run() {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Checking vital signs");
        }
    }

    static class ReportGenerator extends Thread {
        ReportGenerator() { super("ReportGenerator"); }
        public void run() {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Generating routine report");
        }
    }

    public static void main(String[] args) {
        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.setPriority(Thread.MAX_PRIORITY);
        vital.setPriority(Thread.NORM_PRIORITY);
        report.setPriority(Thread.MIN_PRIORITY);

        emergency.start();
        vital.start();
        report.start();
    }
}