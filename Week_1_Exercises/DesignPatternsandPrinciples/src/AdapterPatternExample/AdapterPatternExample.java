package AdapterPatternExample;

interface PaymentProcessor {
    void processPayment(double amount);
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made through Stripe.");
    }
}

class CreditCard {
    public void charge(double amount) {
        System.out.println("Charged $" + amount + " to credit card.");
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

class CreditCardAdapter implements PaymentProcessor {
    private CreditCard creditCard;

    public CreditCardAdapter(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void processPayment(double amount) {
        creditCard.charge(amount);
    }
}

// Test the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(100.0);

        PaymentProcessor creditCardProcessor = new CreditCardAdapter(new CreditCard());
        creditCardProcessor.processPayment(200.0);
    }
}
