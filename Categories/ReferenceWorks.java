package Categories;
public class ReferenceWorks extends Book {
    private String subject; 

    public ReferenceWorks(String title, String author, String ISBN, boolean available, String subject) {
        super(title, author, ISBN, available);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getCategoryDetails() {
        return "Category: Reference Works, Subject: " + subject;
    }
}