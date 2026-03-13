import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year);
    }
}

public class LibraryManager {
    private static ArrayList<Book> library = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Manager ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    library.add(new Book(title, author, year));
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    if (library.isEmpty()) {
                        System.out.println("No books in library.");
                    } else {
                        System.out.println("Books in Library:");
                        for (Book b : library) {
                            b.displayInfo();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    boolean found = false;
                    for (Book b : library) {
                        if (b.getTitle().equalsIgnoreCase(searchTitle)) {
                            b.displayInfo();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
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
