package l_javaPatterns;

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

    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CreditCardPayment());

        paymentContext.PayNow(20);
    }
}
