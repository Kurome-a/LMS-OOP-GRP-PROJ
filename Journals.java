public class Journals extends Book {
    private String journalIssue; // Unique Property

    public Journals(String title, String author, String ISBN, boolean available, String journalIssue) {
        super(title, author, ISBN, available);
        this.journalIssue = journalIssue;
    }

    public String getJournalIssue() {
        return journalIssue;
    }

    public void setJournalIssue(String journalIssue) {
        this.journalIssue = journalIssue;
    }

    @Override
    public String getCategoryDetails() {
        return "Category: Journals, Issue: " + journalIssue;
    }
}
