public class Book implements Comparable<Book> {

    private final String name;
    private final int pageCount;
    private final String author;
    private final int publishDate;

    public Book(String name, int pageCount, String author, int publishDate) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    @Override
    public int compareTo(Book b2) {
        return name.compareTo(b2.name);
    }
}
