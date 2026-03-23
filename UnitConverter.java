import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Unit Converter Menu ===");
            System.out.println("1. Convert Kilometers to Miles");
            System.out.println("2. Convert Kilograms to Pounds");
            System.out.println("3. Convert Celsius to Fahrenheit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter distance in kilometers: ");
                    double km = sc.nextDouble();
                    double miles = km * 0.621371;
                    System.out.println(km + " km = " + miles + " miles");
                    break;

                case 2:
                    System.out.print("Enter weight in kilograms: ");
                    double kg = sc.nextDouble();
                    double pounds = kg * 2.20462;
                    System.out.println(kg + " kg = " + pounds + " pounds");
                    break;

                case 3:
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = sc.nextDouble();
                    double fahrenheit = (celsius * 9/5) + 32;
                    System.out.println(celsius + " °C = " + fahrenheit + " °F");
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
