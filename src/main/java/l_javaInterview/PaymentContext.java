package l_javaInterview;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}


public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void PayNow(int amount) {
        paymentStrategy.pay(amount);
    }
}
