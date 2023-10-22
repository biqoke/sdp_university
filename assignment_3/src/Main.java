import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Device Outlet Connector!");
        System.out.println("Choose an outlet type for your device: ");
        System.out.println("1. US Outlet");
        System.out.println("2. EU Outlet");
        System.out.println("3. UK Outlet");

        int outletChoice = scanner.nextInt();
        PowerSource selectedOutlet = null;

        switch (outletChoice) {
            case 1:
                selectedOutlet = new USOutletAdapter(new USOutlet());   // Create a US outlet adapter
                break;
            case 2:
                selectedOutlet = new EUOutletAdapter(new EUOutlet());   // Create a European outlet adapter
                break;
            case 3:
                selectedOutlet = new UKOutletAdapter(new UKOutlet());   // Create a UK outlet adapter
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
        }

        while (true) {
            System.out.println("Choose an action: ");
            System.out.println("1. Connect Device");
            System.out.println("2. Disconnect Device");
            System.out.println("3. Exit");

            int actionChoice = scanner.nextInt();

            if (actionChoice == 1) {
                selectedOutlet.connect();   // Connect the device to the selected outlet
                System.out.println("------------------------------------------------");
            } else if (actionChoice == 2) {
                selectedOutlet.disconnect();    // Disconnect the device from the selected outlet
                System.out.println("------------------------------------------------");
            } else if (actionChoice == 3) {
                System.out.println("------------------------------------------------");
                break;  // Exit the loop
            } else {
                System.out.println("Invalid action. Please choose a valid action.");
                System.out.println("------------------------------------------------");
            }

        }

        System.out.println("Goodbye!");
    }
}