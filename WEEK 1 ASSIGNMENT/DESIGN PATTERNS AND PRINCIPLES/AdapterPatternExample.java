public class AdapterPatternExample {
    public static void main(String[] args) {
        // Using PayPal through adapter
        PayPal payPal = new PayPal();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        payPalProcessor.processPayment(100.0);

        // Using Stripe through adapter
        Stripe stripe = new Stripe();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(200.0);
    }
}

interface PaymentProcessor {
    void processPayment(double amount);
}

// PayPal payment gateway with its own method
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// Stripe payment gateway with its own method
class Stripe {
    public void sendPayment(double amount) {
        System.out.println("Processing Stripe payment of $" + amount);
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.sendPayment(amount);
    }
}
