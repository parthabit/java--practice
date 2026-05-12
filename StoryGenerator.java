import java.util.*;

public class StoryGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int choice;

        String[] heroes = {"wizard", "knight", "scientist", "robot", "detective"};
        String[] places = {"forest", "castle", "space station", "island", "city"};
        String[] quests = {"find a treasure", "solve a mystery", "defeat a dragon", "invent a cure", "escape a maze"};

        do {
            System.out.println("\n--- Random Story Generator ---");
            System.out.println("1. Generate a short story");
            System.out.println("2. Add a new hero");
            System.out.println("3. Add a new place");
            System.out.println("4. Add a new quest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    String hero = heroes[rand.nextInt(heroes.length)];
                    String place = places[rand.nextInt(places.length)];
                    String quest = quests[rand.nextInt(quests.length)];
                    System.out.println("Once upon a time, a " + hero + " traveled to the " + place + " to " + quest + ".");
                    break;

                case 2:
                    System.out.print("Enter a new hero: ");
                    String newHero = sc.nextLine();
                    heroes = Arrays.copyOf(heroes, heroes.length + 1);
                    heroes[heroes.length - 1] = newHero;
                    System.out.println("Hero added!");
                    break;

                case 3:
                    System.out.print("Enter a new place: ");
                    String newPlace = sc.nextLine();
                    places = Arrays.copyOf(places, places.length + 1);
                    places[places.length - 1] = newPlace;
                    System.out.println("Place added!");
                    break;

                case 4:
                    System.out.print("Enter a new quest: ");
                    String newQuest = sc.nextLine();
                    quests = Arrays.copyOf(quests, quests.length + 1);
                    quests[quests.length - 1] = newQuest;
                    System.out.println("Quest added!");
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

