package Task_3;

public class KaspiKZPaymentStrategy implements PaymentStrategy {
    private String n;

    public KaspiKZPaymentStrategy(String n) {
        this.n = n;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Kaspi QR. Phone number: " + n);
    }
}
