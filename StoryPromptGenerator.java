
import java.util.Random;

public class StoryPromptGenerator {
    public static void main(String[] args) {
        String[] characters = {
            "a brave knight", "an alien explorer", "a mischievous hacker",
            "a talking cat", "a time traveler"
        };

        String[] settings = {
            "in a haunted castle", "on a distant planet", "inside a virtual reality",
            "during a thunderstorm", "in the middle of a desert"
        };

        String[] conflicts = {
            "searching for a lost treasure", "trying to escape danger",
            "solving a mysterious puzzle", "facing their greatest fear",
            "protecting a secret"
        };

        Random rand = new Random();

        String character = characters[rand.nextInt(characters.length)];
        String setting = settings[rand.nextInt(settings.length)];
        String conflict = conflicts[rand.nextInt(conflicts.length)];

        System.out.println("Your story prompt:");
        System.out.println(character + " " + setting + " while " + conflict + ".");
    }
}
