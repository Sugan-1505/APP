import java.util.Scanner;
interface Payment {
    void makePayment(double amount);
}
class UPI implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("UPI Payment of Rs." + amount + " successful.");
    }
}
class CreditCard implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Credit Card Payment of Rs." + amount + " successful.");
    }
}
class NetBanking implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Net Banking Payment of Rs." + amount + " successful.");
    }
}
public class PaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");
        System.out.print("Select Payment Method: ");
        int choice = sc.nextInt();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        Payment payment;
        switch (choice) {
            case 1:
                payment = new UPI();
                break;
            case 2:
                payment = new CreditCard();
                break;
            case 3:
                payment = new NetBanking();
                break;
            default:
                System.out.println("Invalid payment method.");
                sc.close();
                return;
        }
        payment.makePayment(amount);
        sc.close();
    }
}
