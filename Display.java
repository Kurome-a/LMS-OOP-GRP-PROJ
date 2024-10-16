import java.util.ArrayList;

import Categories.Book;

public class Display {
    public static void showAdminMenu() { // Admin
        System.out.println("Welcome to the Library Management System");
        System.out.println("Admin Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Show All Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void showUserMenu() { // User Interface
        System.out.println("Welcome to the Library");
        System.out.println("User Menu:");
        System.out.println("1. Show All Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void showSuccessMessage(String message) { // Success Promt
        System.out.println(message);
    }

    public static void showAllBooks(ArrayList<Book> books) { // Show all Books
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
}
