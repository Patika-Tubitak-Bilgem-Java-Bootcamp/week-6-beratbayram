import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>(
                List.of(
                        new Book("book-0","John", 12, 1991),
                        new Book("book-1","Joe", 23, 1992),
                        new Book("book-2","Jolly", 332, 1993),
                        new Book("book-3","Jonathan", 12, 1994),
                        new Book("book-4","Jesse", 23, 1995),
                        new Book("book-5","Jack", 25, 1996),
                        new Book("book-6","Jane", 2986, 1997),
                        new Book("book-7","Jayce", 22, 1998),
                        new Book("book-8","Jolly", 24324234, 1999),
                        new Book("book-9","Mr. J.", 0, 2022)
                )
        );

        Map<String, String> bookMap = bookList.stream().collect(Collectors.toMap(book -> book.getName(), book -> book.getAuthor()));
        System.out.println("Book List (Map):");
        bookMap.forEach((bookName, author) -> System.out.printf("\"%s\" from %s\n", bookName, author));

        System.out.println();

        System.out.println("Book List ( Page count > 100):");
        List<Book> newBookList = bookList.stream().filter(book -> book.getPageCount() > 100).toList();
        newBookList.stream().forEach(book -> book.printDetail());
    }
}
