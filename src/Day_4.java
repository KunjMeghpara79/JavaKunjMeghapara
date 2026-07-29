import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day_4 {

    private static final int ITEM_COUNT = 250;
    private static final int PREVIEW_COUNT = 10;

    public static void main(String[] args) {
        List<Book> books = generateBooks();
        printBooksByAuthor(books);
        sortBySerial(books);
        sortByTitle(books);
        sortByAuthor(books);
    }

    private static List<Book> generateBooks() {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= ITEM_COUNT; i++) {
            books.add(new Book("Book " + i, "Author " + (i % 20), String.format("BK%04d", i), i % 2 == 0));
        }
        return books;
    }

    private static void printBooksByAuthor(List<Book> books) {
        Map<String, List<Book>> booksByAuthor = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        booksByAuthor.forEach((author, authorBooks) -> {
            System.out.println(author);
            System.out.println("Total Books : " + authorBooks.size());
            System.out.println();
        });
    }

    private static void sortBySerial(List<Book> books) {
        Collections.sort(books);
        System.out.println("===== Sorted by Serial Number =====");
        printPreview(books);
    }

    private static void sortByTitle(List<Book> books) {
        books.sort(new TitleComparator());
        System.out.println("===== Sorted by Title =====");
        printPreview(books);
    }

    private static void sortByAuthor(List<Book> books) {
        books.sort(new AuthorComparator());
        System.out.println("===== Sorted by Author =====");
        printPreview(books);
    }

    private static void printPreview(List<Book> books) {
        for (int i = 0; i < PREVIEW_COUNT; i++) {
            books.get(i).ShowDetail();
        }
        System.out.println();
    }
}
