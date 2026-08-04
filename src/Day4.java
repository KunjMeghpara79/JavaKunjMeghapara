import java.util.*;
import java.util.stream.Collectors;

public class Day4 {

    private static final int ITEM_COUNT = 250;
    private static final int PREVIEW_COUNT = 10;

    public static void main(String[] args) throws LibraryDataException {

        List<Book> books = generateBooks();

        // Using custom functional interface and overridden method using lambda expression
        printFormattedBook(
                books.get(0), b -> "Book : " + b.getTitle()
                        + " | Author : " + b.getAuthor()
                        + " | Available : " + b.isAvailable());

        System.out.println();

        // Using Optional for a real null check
        Book found = findBookBySerial(books, "BK0005");
        displayBook(found);
        Book notFound = findBookBySerial(books, "BK9999");
        displayBook(notFound);
        System.out.println();
        printBooksByAuthor(books);
        sortBySerial(books);
        sortBySerialUsingStreams(books);
        sortByTitle(books);
        sortByTitleUsingStreams(books);
        sortByAuthor(books);
        sortByAuthorUsingStreams(books);
        partitionBooksByAvailability(books);

    }

    private static List<Book> generateBooks() throws LibraryDataException {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= ITEM_COUNT; i++) {
            books.add(new Book(
                    "Book " + i,
                    "Author " + (i % 20),
                    String.format("BK%04d", i),
                    i % 2 == 0
            ));
        }
        return books;
    }

    private static void printBooksByAuthor(List<Book> books) {
        Map<String, List<Book>> booksByAuthor =
                books.stream().collect(Collectors.groupingBy(Book::getAuthor));

        booksByAuthor.forEach((author, authorBooks) -> {
            System.out.println(author);
            System.out.println("Total Books : " + authorBooks.size());
            System.out.println();
        });
    }

    private static void sortBySerial(List<Book> books) {
        Collections.sort(books);

        // Natural ordering using Comparable
        System.out.println("===== Sorted by Serial Number =====");
        printPreview(books);
    }

    public static void sortBySerialUsingStreams(List<Book> books) {
        books = books.stream()
                .sorted((b1, b2) -> b1.getSr_no().compareTo(b2.getSr_no()))
                .toList();

        printPreview(books);
    }

    public static void partitionBooksByAvailability(List<Book> books) {

        Map<Boolean, List<Book>> result = books.stream()
                .collect(Collectors.partitioningBy(Book::isAvailable));

        System.out.println("----------------Available Books----------------");
        result.get(true).forEach(Book::ShowDetail);

        System.out.println("\n----------------Unavailable Books----------------");
        result.get(false).forEach(Book::ShowDetail);
    }

    private static void sortByTitle(List<Book> books) {

        books.sort(new TitleComparator());

        System.out.println("===== Sorted by Title =====");
        printPreview(books);
    }

    public static void sortByTitleUsingStreams(List<Book> books) {

        books = books.stream()
                .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .toList();

        printPreview(books);
    }

    private static void sortByAuthor(List<Book> books) {

        books.sort(new AuthorComparator());

        System.out.println("===== Sorted by Author =====");
        printPreview(books);
    }

    public static void sortByAuthorUsingStreams(List<Book> books) {

        books = books.stream()
                .sorted((b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()))
                .toList();

        printPreview(books);
    }

    private static void printPreview(List<Book> books) {

        for (int i = 0; i < PREVIEW_COUNT; i++) {
            books.get(i).ShowDetail();
        }

        System.out.println();
    }


    private static void printFormattedBook(Book book, BookFormatter formatter) {
        System.out.println(formatter.format(book));
    }

    private static Book findBookBySerial(List<Book> books, String serial) {

        return books.stream()
                .filter(book -> book.getSr_no().equals(serial))
                .findFirst()
                .orElse(null);
    }

    // Optional replacing a real null check
    private static void displayBook(Book book) {

        Optional.ofNullable(book).ifPresentOrElse(Book::ShowDetail, () -> System.out.println("Book not found."));
    }
}