package Task_3;

public class HalykBankPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public HalykBankPaymentStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " using Halyk Bank ending in " + cardNumber);
    }
}
