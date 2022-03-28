import java.time.LocalDate;
import java.util.Date;

public class Book {
    private String name;
    private int pageCount;
    private String author;
    private int publishedYear;

    public Book(String name, String author, int pageCount, int publishedYear) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authorName) {
        this.author = authorName;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void printDetail() {
        System.out.printf("\"%s\" from %s at %d (%d)\n", this.name, this.author, this.pageCount, this.publishedYear);
    }
}