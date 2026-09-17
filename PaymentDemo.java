interface Payment {
    void pay(double amount);
}
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount +
                           " made using Credit Card.");
    }
}
class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount +
                           " made using UPI.");
    }
}
class NetBankingPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount +
                           " made using Net Banking.");
    }
}
public class PaymentDemo {
    public static void main(String[] args) {
        Payment payment;
        payment = new CreditCardPayment();
        payment.pay(5000);
        payment = new UPIPayment();
        payment.pay(2500);
        payment = new NetBankingPayment();
        payment.pay(3000);
    }
}
