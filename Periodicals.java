

public class Periodicals extends Book {
    private String publicationFrequency; //Unique Property

    public Periodicals(String title, String author, String ISBN, boolean available, String publicationFrequency) {
        super(title, author, ISBN, available);
        this.publicationFrequency = publicationFrequency;
    }

    @Override
    public String getCategoryDetails() {
        return "Category: Periodicals, Frequency: " + publicationFrequency;
    }
}
