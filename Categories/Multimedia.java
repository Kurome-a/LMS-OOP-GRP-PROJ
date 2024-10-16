package Categories;
public class Multimedia extends Book {
    private String formatType; //Unique Property

    public Multimedia(String title, String author, String ISBN, boolean available, String formatType) {
        super(title, author, ISBN, available);
        this.formatType = formatType;
    }

    @Override
    public String getCategoryDetails() {
        return "Category: Multimedia, Format: " + formatType;
    }
}
