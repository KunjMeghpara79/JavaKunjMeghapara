import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface LibItemRecord {
    void showDetail();
}

class LibraryRecord {
    private String name;
    private List<LibItemRecord> items;

    LibraryRecord(String name, List<LibItemRecord> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<LibItemRecord> getItems() {
        return items;
    }
}

record BookRec(String title, String author, String serialNo, boolean available) implements LibItemRecord, Comparable<BookRec> {

    public BookRec {
        if (serialNo.length() != 6) {
            throw new IllegalArgumentException("Invalid Serial Number!");
        }
    }

    @Override
    public void showDetail() {
        System.out.println("Book Details");
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Serial No   : " + serialNo);
        System.out.println("Status      : " + (available ? "Available" : "Not Available"));
    }

    @Override
    public int compareTo(BookRec other) {
        return serialNo.compareTo(other.serialNo);
    }
}

record NovelRec(String title, String author, String serialNo, boolean available) implements LibItemRecord {

    public NovelRec {
        if (serialNo.length() != 6) {
            throw new IllegalArgumentException("Invalid Serial Number!");
        }
    }

    @Override
    public void showDetail() {
        System.out.println("Novel Details");
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Serial No   : " + serialNo);
        System.out.println("Status      : " + (available ? "Available" : "Not Available"));

    }
}

public class Day_5 {

    public static void main(String[] args) {

        List<LibItemRecord> list = new ArrayList<>();

        LibraryRecord library = new LibraryRecord("Public Library", list);

        BookRec b1 = new BookRec("Atomic Habits", "James Clear", "BK1001", true);

        BookRec b2 = new BookRec("48 Laws of Power", "Robert Greene", "BK1002", false);

        NovelRec n1 = new NovelRec("The Diary of a CEO", "Steven Bartlett", "NV2001", true);

        NovelRec n2 = new NovelRec("The Laws of Human Nature", "Robert Greene", "NV2002", false);

        list.add(b1);
        list.add(b2);
        list.add(n1);
        list.add(n2);

        System.out.println("===== " + library.getName() + " =====\n");

        for (LibItemRecord item : library.getItems()) {
            item.showDetail();
            System.out.println("------------------------------");
        }

        System.out.println("\n===== Sorting Books =====");

        List<BookRec> books = new ArrayList<>();
        books.add(b2);
        books.add(b1);

        Collections.sort(books);

        for (BookRec book : books) {
            System.out.println(book.serialNo() + " -> " + book.title());
        }

        System.out.println("\n===== Record Methods =====");
        System.out.println("Title      : " + b1.title());
        System.out.println("Author     : " + b1.author());
        System.out.println("Serial No  : " + b1.serialNo());
        System.out.println("Available  : " + b1.available());

        System.out.println("\n===== Auto-generated toString() =====");
        System.out.println(b1);

        System.out.println("\n===== equals() Demo =====");
        BookRec b3 = new BookRec("Atomic Habits", "James Clear", "BK1001", true);

        System.out.println("b1.equals(b3) = " + b1.equals(b3));

        System.out.println("\n===== hashCode() Demo =====");
        System.out.println("b1.hashCode() = " + b1.hashCode());
        System.out.println("b3.hashCode() = " + b3.hashCode());
    }
}