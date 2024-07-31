
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("32458833032", "Keerthana", "123");
        context.setPaymentStrategy(creditCardPayment);
        context.pay(100.0);

        // Pay using PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("Keerthana.sa@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.pay(200.0);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}
