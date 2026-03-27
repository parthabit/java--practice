import java.util.Random;
import java.util.Scanner;

public class FantasyNameGenerator {

    private static final String[] prefixes = {
        "Ara", "Bel", "Cor", "Dra", "Ely", "Fen", "Gal", "Hel", "Ira", "Jor"
    };

    private static final String[] middles = {
        "dor", "mir", "thal", "ven", "lor", "rin", "sil", "tor", "mar", "zen"
    };

    private static final String[] suffixes = {
        "ion", "ius", "ara", "eth", "or", "an", "iel", "os", "en", "is"
    };

    private static String generateName() {
        Random rand = new Random();
        String name = prefixes[rand.nextInt(prefixes.length)]
                    + middles[rand.nextInt(middles.length)]
                    + suffixes[rand.nextInt(suffixes.length)];
        return name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Fantasy Name Generator ---");
            System.out.println("1. Generate a random fantasy name");
            System.out.println("2. Exit");
            System.out.print("Enter your choice (1-2): ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Generated Name: " + generateName());
            } else if (choice.equals("2")) {
                System.out.println("Goodbye! May your stories be legendary!");
                break;
            } else {
                System.out.println("Invalid choice! Please select 1 or 2.");
            }
        }
        scanner.close();
    }
}
