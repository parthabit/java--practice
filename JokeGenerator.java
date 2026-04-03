import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JokeGenerator {
    private static List<String> jokes = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        // Preloaded jokes
        jokes.add("Why don’t scientists trust atoms? Because they make up everything!");
        jokes.add("Why did the math book look sad? Because it had too many problems.");
        jokes.add("Why can’t your nose be 12 inches long? Because then it would be a foot!");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    getRandomJoke();
                    break;
                case 2:
                    addJoke(scanner);
                    break;
                case 3:
                    viewJokes();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=== Joke Generator Menu ===");
        System.out.println("1. Get a random joke");
        System.out.println("2. Add a new joke");
        System.out.println("3. View all jokes");
        System.out.println("4. Exit");
    }

    private static void getRandomJoke() {
        if (!jokes.isEmpty()) {
            String joke = jokes.get(random.nextInt(jokes.size()));
            System.out.println("\nJoke: " + joke);
        } else {
            System.out.println("\nNo jokes available yet!");
        }
    }

    private static void addJoke(Scanner scanner) {
        System.out.print("\nEnter your joke: ");
        String newJoke = scanner.nextLine();
        jokes.add(newJoke);
        System.out.println("Joke added successfully!");
    }

    private static void viewJokes() {
        if (!jokes.isEmpty()) {
            System.out.println("\n=== All Jokes ===");
            for (int i = 0; i < jokes.size(); i++) {
                System.out.println((i + 1) + ". " + jokes.get(i));
            }
        } else {
            System.out.println("\nNo jokes stored yet!");
        }
    }
}
