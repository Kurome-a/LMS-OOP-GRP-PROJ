package Categories;
public class Books extends Book {
    public Books(String title, String author, String ISBN, boolean available) {
        super(title, author, ISBN, available);
    }

    @Override
    public String getCategoryDetails() {
        return "Category: General Books";
    }
}
