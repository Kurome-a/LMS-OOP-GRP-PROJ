import java.util.Scanner;

class LibraryManagementSystem {
    private static final String ADMIN_PASSWORD = "LMSadmin"; // Admin password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
    
        while (true) {
            System.out.println("Select Role:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
    
            System.out.print("Enter your choice: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine();
    
            switch (roleChoice) {
                case 1: // Admin
                    if (verifyAdminPassword(scanner)) {
                        adminMenu(scanner, library);
                    } else {
                        System.out.println("Incorrect password. Returning to role selection.");
                        System.out.println("");
                    }
                    break;
    
                case 2: // User
                    userMenu(scanner, library);
                    break;
    
                case 3: // Exit
                    Display.showSuccessMessage("Exiting system. Goodbye!");
                    return; // Exit the program
    
                default: // Invalid choice
                    System.out.println("Invalid role. Please try again.");
                    System.out.println("");
                    break;
            }
        }
    }
    

    // Verify the admin password
    public static boolean verifyAdminPassword(Scanner scanner) {
        System.out.print("Enter Admin password: ");
        String enteredPassword = scanner.nextLine();

        if (ADMIN_PASSWORD.equals(enteredPassword)) {
            System.out.println("Access granted.");
            System.out.println("");
            return true;
        } else {
            System.out.println("Access denied. Incorrect password.");
            System.out.println("");
            return false;
        }
    }

    public static void adminMenu(Scanner scanner, Library library) {
        while (true) {
            Display.showAdminMenu();
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
                    boolean available = true;
        
                    // Ask for book category
                    System.out.println("Select Category:");
                    System.out.println("1. General Books");
                    System.out.println("2. Periodicals");
                    System.out.println("3. Multimedia");
                    System.out.println("4. Databases");
                    System.out.println("5. Reference Works");
                    System.out.println("6. Maps");
                    System.out.println("7. Journals");
                    System.out.print("Enter Category: ");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();
    
                    String itemType = "book"; // Default category label
                    Book newBook = null;
                    
                    // Determine the type of item being added
                    switch (categoryChoice) {
                        case 1:
                            newBook = new Books(title, author, ISBN, available);
                            itemType = "book"; // General Books
                            break;
                        case 2:
                            System.out.print("Enter publication frequency: ");
                            String publicationFrequency = scanner.nextLine();
                            newBook = new Periodicals(title, author, ISBN, available, publicationFrequency);
                            itemType = "periodical";
                            break;
                        case 3:
                            System.out.print("Enter format type: ");
                            String formatType = scanner.nextLine();
                            newBook = new Multimedia(title, author, ISBN, available, formatType);
                            itemType = "multimedia item";
                            break;
                        case 4:
                            System.out.print("Enter access method: ");
                            String accessMethod = scanner.nextLine();
                            newBook = new Databases(title, author, ISBN, available, accessMethod);
                            itemType = "database";
                            break;
                        case 5:
                            System.out.print("Enter subject: ");
                            String subject = scanner.nextLine();
                            newBook = new ReferenceWorks(title, author, ISBN, available, subject);
                            itemType = "reference work";
                            break;
                        case 6:
                            System.out.print("Enter region covered: ");
                            String regionCovered = scanner.nextLine();
                            newBook = new Maps(title, author, ISBN, available, regionCovered);
                            itemType = "map";
                            break;
                        case 7:
                            System.out.print("Enter journal issue: ");
                            String journalIssue = scanner.nextLine();
                            newBook = new Journals(title, author, ISBN, available, journalIssue);
                            itemType = "journal";
                            break;
                        default:
                            System.out.println("Invalid category. Item not added.");
                            System.out.println("");
                            continue;
                    }
    
                    // Add the new item to the library
                    library.addBook(newBook);
                    
                    // Display a success message with the correct item type
                    Display.showSuccessMessage(capitalizeFirstLetter(itemType) + " added successfully.");
                    System.out.println("");
                    break;
    
                case 2: // Removing a book
                    System.out.print("Enter ISBN to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    Display.showSuccessMessage("Item removed successfully.");
                    System.out.println("");
                    break;
    
                case 3: // Show all books
                    Display.showAllBooks(library.getBooks());
                    break;
    
                case 4: // Exit
                    Display.showSuccessMessage("Exiting admin system.");
                    return;
    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("");
            }
        }
    }
    
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    
    

    public static void userMenu(Scanner scanner, Library library) {
        while (true) {
            Display.showUserMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Show all books
                    Display.showAllBooks(library.getBooks());
                    break;

                case 2: // Borrow a book
                    System.out.print("Enter ISBN to borrow: ");
                    String isbnToBorrow = scanner.nextLine();
                    Borrow.borrowBook(library, isbnToBorrow);
                    break;

                case 3: // Returning a book
                    System.out.print("Enter ISBN to return: ");
                    String isbnToReturn = scanner.nextLine();
                    Return.returnBook(library, isbnToReturn);
                    break;

                case 4: // Exit
                    Display.showSuccessMessage("Exiting user system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("");
            }
        }
    }
}
