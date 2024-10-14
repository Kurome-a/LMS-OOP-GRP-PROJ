public class Maps extends Book {
    private String regionCovered; // Unique Property

    public Maps(String title, String author, String ISBN, boolean available, String regionCovered) {
        super(title, author, ISBN, available);
        this.regionCovered = regionCovered;
    }

    public String getRegionCovered() {
        return regionCovered;
    }

    public void setRegionCovered(String regionCovered) {
        this.regionCovered = regionCovered;
    }

    @Override
    public String getCategoryDetails() {
        return "Category: Maps, Region Covered: " + regionCovered;
    }
}