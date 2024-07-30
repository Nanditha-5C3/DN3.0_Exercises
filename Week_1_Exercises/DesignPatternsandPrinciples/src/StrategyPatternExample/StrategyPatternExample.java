package StrategyPatternExample;

interface PaymentStrategy {
    void pay(double amount);
}

class CardPayment implements PaymentStrategy {
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

class EmailPayment implements PaymentStrategy {
    private String email;

    public EmailPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy cardPayment = new CardPayment("1234-5678-9876-5432");
        PaymentContext context = new PaymentContext(cardPayment);
        context.executePayment(200.0);

        PaymentStrategy emailPayment = new EmailPayment("user@example.com");
        context = new PaymentContext(emailPayment);
        context.executePayment(150.0);
    }
}
