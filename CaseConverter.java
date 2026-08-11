import java.util.Scanner;

public class CaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Choose conversion:");
        System.out.println("1. Lowercase");
        System.out.println("2. Uppercase");
        System.out.println("3. Title Case");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: System.out.println("Lowercase: " + text.toLowerCase()); break;
            case 2: System.out.println("Uppercase: " + text.toUpperCase()); break;
            case 3:
                String[] words = text.split(" ");
                StringBuilder sb = new StringBuilder();
                for (String w : words)
                    sb.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1).toLowerCase()).append(" ");
                System.out.println("Title Case: " + sb.toString().trim());
                break;
            default: System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
