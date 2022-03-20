import java.util.TreeSet;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> bookSet = new TreeSet<>();

        bookSet.add(new Book("Book 1", 15, "author 1", 2001));
        bookSet.add(new Book("Book 2", 112, "author 2", 2002));
        bookSet.add(new Book("Book 3", 132432, "author 3", 2003));
        bookSet.add(new Book("Book 4", 34, "author 4", 2004));
        bookSet.add(new Book("Book 5", 2, "author 5", 2005));

        System.out.println("Sorted by name:");
        bookSet.forEach(book -> System.out.printf("%s: %d\n", book.getName(), book.getPageCount()));

        TreeSet<Book> bookSet2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPageCount() - b2.getPageCount();
            }
        });

        bookSet2.addAll(bookSet);

        System.out.println("Sorted by page count:");
        bookSet2.forEach(book -> System.out.printf("%s: %d\n", book.getName(), book.getPageCount()));
    }
}
