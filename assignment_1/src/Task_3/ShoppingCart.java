package Task_3;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotalPrice() {
        double totalP = 0;
        for (Product item : items) {
            totalP += item.getPrice() * item.getQuantity();
        }
        return totalP;
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double totalP = calculateTotalPrice();
        paymentStrategy.processPayment(totalP);
    }

    public List<Product> getItems() {
        return items;
    }
}
