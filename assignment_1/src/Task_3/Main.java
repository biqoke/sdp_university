package Task_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Phone", 750, 2);
        Product p2 = new Product("iPhone", 1500, 1);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1);
        cart.addProduct(p2);

        System.out.println("Cart:");
        for (Product item : cart.getItems()) {
            System.out.println(item.getName() + " - Price: " + item.getPrice() + "$" +
                    " - Quantity: " + item.getQuantity());
        }

        PaymentStrategy halykbankPayment = new HalykBankPaymentStrategy("1234-1111-2222-7777", "Shaikhy Beksultan");
        PaymentStrategy kaspikzPayment = new KaspiKZPaymentStrategy("+7 777 777 77 77");

        Scanner scanner = new Scanner(System.in);

            System.out.println("Select a payment strategy:");
            System.out.println("1. Halyk Bank");
            System.out.println("2. Kaspi.kz");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                cart.checkout(halykbankPayment);
            } else if (choice == 2) {
                cart.checkout(kaspikzPayment);
            } else {
                System.out.println("Invalid choice.");
            }
    }
}
