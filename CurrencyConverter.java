import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("\n--- Currency Converter Menu ---");
            System.out.println("1. INR to USD");
            System.out.println("2. INR to EUR");
            System.out.println("3. INR to GBP");
            System.out.println("4. USD to INR");
            System.out.println("5. EUR to INR");
            System.out.println("6. GBP to INR");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 6) {
                System.out.print("Enter amount: ");
                amount = sc.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("INR to USD: " + (amount * 0.012));
                        break;
                    case 2:
                        System.out.println("INR to EUR: " + (amount * 0.011));
                        break;
                    case 3:
                        System.out.println("INR to GBP: " + (amount * 0.0095));
                        break;
                    case 4:
                        System.out.println("USD to INR: " + (amount * 83.0));
                        break;
                    case 5:
                        System.out.println("EUR to INR: " + (amount * 90.0));
                        break;
                    case 6:
                        System.out.println("GBP to INR: " + (amount * 105.0));
                        break;
                }
            } else if (choice != 7) {
                System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        System.out.println("Thank you for using Currency Converter!");
        sc.close();
    }
}
