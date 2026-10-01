class FoodDeliveryMultithreading {
    static class OrderProcessing extends Thread {
        OrderProcessing() { super("OrderProcessing"); }
        public void run() {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Processing customer orders");
        }
    }

    static class DeliveryTracking extends Thread {
        DeliveryTracking() { super("DeliveryTracking"); }
        public void run() {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Tracking delivery locations");
        }
    }

    static class Notification extends Thread {
        Notification() { super("Notification"); }
        public void run() {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Sending order-status notifications");
        }
    }

    public static void main(String[] args) {
        OrderProcessing order = new OrderProcessing();
        DeliveryTracking tracking = new DeliveryTracking();
        Notification notification = new Notification();

        order.setPriority(Thread.MAX_PRIORITY);
        tracking.setPriority(Thread.NORM_PRIORITY);
        notification.setPriority(Thread.MIN_PRIORITY);

        order.start();
        tracking.start();
        notification.start();
    }
}