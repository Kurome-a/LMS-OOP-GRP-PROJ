import Categories.Book;

public class Borrow {
    public static void borrowBook(Library library, String ISBN) {
        if (library.getBooks().isEmpty()) {
            System.out.println("The library is empty. There are no books to borrow.");
            return;
        }

        Book bookToBorrow = findBookByISBN(library, ISBN);

        if (bookToBorrow != null) {
            if (bookToBorrow.isAvailable()) {
                bookToBorrow.setAvailable(false);
                System.out.println("You have successfully borrowed the book: " + bookToBorrow.getTitle());
            } else {
                System.out.println("Sorry, this book is currently unavailable.");
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
