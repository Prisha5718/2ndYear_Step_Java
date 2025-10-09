// PaymentGateway.java
public interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

// CreditCardPayment.java
public class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to Credit Card");
    }
}

// UPIPayment.java
public class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded $" + amount + " to UPI");
    }
}

// PaymentTest.java
public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway cc = new CreditCardPayment();
        cc.pay(150);
        cc.refund(50);

        PaymentGateway upi = new UPIPayment();
        upi.pay(200);
        upi.refund(75);
    }
}
