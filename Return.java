public class Return {
    public static void returnBook(Library library, String ISBN) {
        if (library.getBooks().isEmpty()) {
            System.out.println("The library is empty. There are no books to return.");
            return;
        }

        Book bookToReturn = findBookByISBN(library, ISBN);

        if (bookToReturn != null) {
            if (!bookToReturn.isAvailable()) {
                bookToReturn.setAvailable(true);
                System.out.println("You have successfully returned the book: " + bookToReturn.getTitle());
            } else {
                System.out.println("This book was not borrowed.");
            }
        } else {
            System.out.println("No book found with ISBN: " + ISBN);
        }
    }

    private static Book findBookByISBN(Library library, String ISBN) {
        for (Book book : library.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
}
