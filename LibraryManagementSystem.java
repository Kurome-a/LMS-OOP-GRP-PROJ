import java.util.Scanner;

class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            Display.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Adding a book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter availability (true/false): ");
                    boolean available = scanner.nextBoolean();
                    scanner.nextLine();

                    Categories category = null;
                    while (category == null) {
                        Display.showCategoryMenu();
                        String categoryInput = scanner.nextLine().toUpperCase();

                        try {
                            category = Categories.valueOf(categoryInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid category. Please try again.");
                        }
                    }

                    library.addBook(new Book(title, author, ISBN, available, category));
                    Display.showSuccessMessage("Book added successfully.");
                    break;

                case 2: // Removing a book
                    System.out.print("Enter ISBN to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    Display.showSuccessMessage("Book removed successfully.");
                    break;

                case 3: // Show all
                    Display.showAllBooks(library.getBooks());
                    break;

                case 4: // Borrow a book
                    System.out.print("Enter ISBN to borrow: ");
                    String isbnToBorrow = scanner.nextLine();
                    Borrow.borrowBook(library, isbnToBorrow);
                    break;

                case 5: // Returning a book
                    System.out.print("Enter ISBN to return: ");
                    String isbnToReturn = scanner.nextLine();
                    Return.returnBook(library, isbnToReturn);
                    break;

                case 6: // Exit
                    Display.showSuccessMessage("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
