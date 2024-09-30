public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;
    private Categories category;

    public Book(String title, String author, String ISBN, boolean available, Categories category) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = available;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
