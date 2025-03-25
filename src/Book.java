import java.util.Objects;

public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        if (Objects.isNull(title) || title.isEmpty()) {
            throw new IllegalArgumentException("Title can not be empty.");
        }
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }
        this.title = title;
        this.pageCount = pageCount;
    }
    public String getTitle() {
        return title;
    }
    public int getPageCount() {
        return pageCount;
    }
    @Override
    public String toString() {
        return title + " ( " + pageCount +" pages )";
    }
}