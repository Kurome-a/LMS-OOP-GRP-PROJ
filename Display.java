import java.util.ArrayList;

public class Display {
    public static void showMenu() {
        System.out.println("Library Management System:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Show All Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void showSuccessMessage(String message) {
        System.out.println(message);
    }

    public static void showAllBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
                System.out.println("---------------------------");
            }
        }
    }

    public static void showCategoryMenu() {
        System.out.println("Available categories:");
        for (Categories category : Categories.values()) {
            System.out.println("- " + category.name());
        }
        System.out.print("Enter the category name: ");
    }
}
