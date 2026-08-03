import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 {

    public static void main(String[] args) {
        List<LibraryItems> items = new ArrayList<>();
        LibraryRec library = new LibraryRec("Public Library", items);

        BookRec b1 = new BookRec("Atomic Habits", "James Clear", "BK1001", true);
        BookRec b2 = new BookRec("48 Laws of Power", "Robert Greene", "BK1002", false);
        NovelRec n1 = new NovelRec("The Diary of a CEO", "Steven Bartlett", "NV2001", true);
        NovelRec n2 = new NovelRec("The Laws of Human Nature", "Robert Greene", "NV2002", false);
        items.add(b1);
        items.add(b2);
        items.add(n1);
        items.add(n2);
        printLibraryItems(library);
        sortAndPrintBooks(b1, b2);
        demonstrateRecordMethods(b1);
        demonstrateToString(b1);
        demonstrateEquals(b1);
        demonstrateHashCode(b1);
    }

    private static void printLibraryItems(LibraryRec library) {
        System.out.println("===== " + library.getName() + " =====\n");
        for (LibraryItems item : library.getItems()) {
            item.ShowDetail();
            System.out.println("------------------------------");
        }
    }

    private static void sortAndPrintBooks(BookRec b1, BookRec b2) {
        System.out.println("\n===== Sorting Books =====");
        List<BookRec> books = new ArrayList<>();
        books.add(b2);
        books.add(b1);
        Collections.sort(books);
        for (BookRec book : books) {
            System.out.println(book.serialNo() + " -> " + book.title());
        }
    }

    private static void demonstrateRecordMethods(BookRec book) {
        System.out.println("\n===== Record Methods =====");
        System.out.println("Title      : " + book.title());
        System.out.println("Author     : " + book.author());
        System.out.println("Serial No  : " + book.serialNo());
        System.out.println("Available  : " + book.available());
    }

    private static void demonstrateToString(BookRec book) {
        System.out.println("\n===== Auto-generated toString() =====");
        System.out.println(book);
    }

    private static void demonstrateEquals(BookRec book) {
        System.out.println("\n===== equals() Demo =====");
        BookRec copy = new BookRec(book.title(), book.author(), book.serialNo(), book.available());
        System.out.println("b1.equals(copy) = " + book.equals(copy));
    }

    private static void demonstrateHashCode(BookRec book) {
        System.out.println("\n===== hashCode() Demo =====");
        BookRec copy = new BookRec(book.title(), book.author(), book.serialNo(), book.available());
        System.out.println("b1.hashCode() = " + book.hashCode());
        System.out.println("copy.hashCode() = " + copy.hashCode());
    }
}
