import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PromotionManager promotionManager = new PromotionManager();
        List<ShopObserver> clients = new ArrayList<>();

        clients.add(new Customer("Beksultan"));
        clients.add(new Customer("Arman"));
        clients.add(new Customer("Maksat"));

        for (ShopObserver client : clients) {
            promotionManager.subscribe(client);
        }

        ProductFactory productFactory = new ProductFactory();

        productFactory.registerFactory("food", (name, price, description) -> new FoodProduct(name, price, description));
        productFactory.registerFactory("clothing", (name, price, description) -> new ClothingProduct(name, price, description));
        productFactory.registerFactory("electronics", (name, price, description) -> new ElectronicsProduct(name, price, description));

        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        System.out.println("_______________________________");
        System.out.println("Welcome to Online Shopping App!");
        System.out.println("_______________________________");

        while (continueShopping) {
            System.out.println("Select an option:");
            System.out.println("1. Create and display a product");
            System.out.println("2. Create a promotion");
            System.out.println("3. Add a new client");
            System.out.println("4. Exit");
            System.out.println("_______________________________");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("_______________________________");
                    System.out.println("Enter product type (food, clothing, electronics):");
                    String productType = scanner.next();
                    System.out.println("Enter product name:");
                    String productName = scanner.next();
                    System.out.println("Enter product price:");
                    double productPrice = scanner.nextDouble();
                    System.out.println("Enter product description:");
                    scanner.nextLine();
                    String productDescription = scanner.nextLine();
                    Product product = productFactory.createProduct(productType, productName, productPrice, productDescription);
                    if (product != null) {
                        product.display();
                    } else {
                        System.out.println("Invalid product type.");
                    }
                    System.out.println("_______________________________");
                    break;
                case 2:
                    System.out.println("_______________________________");
                    System.out.println("Enter promotion message:");
                    scanner.nextLine();
                    String promotionMessage = scanner.nextLine();
                    promotionManager.createPromotion(promotionMessage);
                    System.out.println("_______________________________");
                    break;
                case 3:
                    System.out.println("_______________________________");
                    System.out.println("Enter the name of the new client:");
                    scanner.nextLine();
                    String clientName = scanner.nextLine();
                    ShopObserver newClient = new Customer(clientName);
                    clients.add(newClient);
                    promotionManager.subscribe(newClient);
                    System.out.println(clientName + " has been added as a client.");
                    System.out.println("_______________________________");
                    break;
                case 4:
                    continueShopping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("_______________________________");
        System.out.println("Thank you for using our online shopping system!");
        System.out.println("_______________________________");
    }
}
