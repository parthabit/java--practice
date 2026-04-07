import java.util.Scanner;

public class UnitConverterMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Unit Converter Menu ===");
            System.out.println("1. Length Converter (meters ↔ kilometers)");
            System.out.println("2. Weight Converter (grams ↔ kilograms)");
            System.out.println("3. Temperature Converter (Celsius ↔ Fahrenheit)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lengthConverter(sc);
                    break;
                case 2:
                    weightConverter(sc);
                    break;
                case 3:
                    temperatureConverter(sc);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();

        
    }

    // Length Converter
    public static void lengthConverter(Scanner sc) {
        System.out.println("\n-- Length Converter --");
        System.out.println("1. Meters to Kilometers");
        System.out.println("2. Kilometers to Meters");
        System.out.print("Choose conversion: ");
        int option = sc.nextInt();

        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        if (option == 1) {
            System.out.println(value + " meters = " + (value / 1000) + " kilometers");
        } else if (option == 2) {
            System.out.println(value + " kilometers = " + (value * 1000) + " meters");
        } else {
            System.out.println("Invalid option!");
        }
    }

    // Weight Converter
    public static void weightConverter(Scanner sc) {
        System.out.println("\n-- Weight Converter --");
        System.out.println("1. Grams to Kilograms");
        System.out.println("2. Kilograms to Grams");
        System.out.print("Choose conversion: ");
        int option = sc.nextInt();

        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        if (option == 1) {
            System.out.println(value + " grams = " + (value / 1000) + " kilograms");
        } else if (option == 2) {
            System.out.println(value + " kilograms = " + (value * 1000) + " grams");
        } else {
            System.out.println("Invalid option!");
        }
    }

    // Temperature Converter
    public static void temperatureConverter(Scanner sc) {
        System.out.println("\n-- Temperature Converter --");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose conversion: ");
        int option = sc.nextInt();

        System.out.print("Enter value: ");
        double value = sc.nextDouble();

        if (option == 1) {
            System.out.println(value + " °C = " + ((value * 9/5) + 32) + " °F");
        } else if (option == 2) {
            System.out.println(value + " °F = " + ((value - 32) * 5/9) + " °C");
        } else {
            System.out.println("Invalid option!");
        }
    }
}
