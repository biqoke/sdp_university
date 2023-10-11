import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the CoffeeBOOM!");
        System.out.println("Available Coffee Types:");
        System.out.println("1. Cappuccino - 990тг");
        System.out.println("2. Latte - 990тг");
        System.out.println("3. Espresso - 790тг");

        System.out.print("Select a coffee type: ");
        int coffeeChoice = scanner.nextInt();

        Coffee selectedCoffee = null;

        // Create the selected coffee based on the user's choice
        if (coffeeChoice == 1) {
            selectedCoffee = new Cappuccino();
        } else if (coffeeChoice == 2) {
            selectedCoffee = new Latte();
        } else if (coffeeChoice == 3) {
            selectedCoffee = new Espresso();
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Allow the user to customize the coffee with condiments
        System.out.print("Do you want to add Milk - 100тг? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            selectedCoffee = new MilkDecorator(selectedCoffee);
        }

        System.out.print("Do you want to add Sugar - 100тг? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            selectedCoffee = new SugarDecorator(selectedCoffee);
        }

        System.out.print("Do you want to add Chocolate - 200тг? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            selectedCoffee = new ChocolateDecorator(selectedCoffee);
        }

        // Display the customized coffee and its cost
        System.out.println("Your Coffee: " + selectedCoffee.getDescription());
        System.out.println("Total Cost: " + selectedCoffee.cost() + " тг");

        scanner.close();
    }
}
