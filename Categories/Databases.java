package Categories;
public class Databases extends Book {
    private String accessMethod; //Unique Property

    public Databases(String title, String author, String ISBN, boolean available, String accessMethod) {
        super(title, author, ISBN, available);
        this.accessMethod = accessMethod;
    }

    public String getAccessMethod() {
        return accessMethod;
    }

    public void setAccessMethod(String accessMethod) {
        this.accessMethod = accessMethod;
    }

    @Override
    public String getCategoryDetails() {
        return "Category: Databases, Access Method: " + accessMethod;
    }
}