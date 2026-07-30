import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day_3 {

    private static final int ITEM_COUNT = 250;
    private static final String SERIAL_TO_REMOVE = "BK0100";
    private static final String SERIAL_TO_SEARCH = "NV0200";

    public static void main(String[] args) {
        List<Library_items> items = new ArrayList<>();
        Set<String> authors = new HashSet<>();
        Map<String, Library_items> itemsBySerial = new HashMap<>();
        Library library = new Library("Public Library", items);

        populateBooks(items, authors, itemsBySerial);
        // this method call creates one new instance of a book and add it in the list,set and map.

        populateNovels(items, authors, itemsBySerial);
        //this method call do the same for novels

        printSummary(library, authors);

        addBook(items, authors, itemsBySerial, new Book("Atomic Habits", "James Clear", "BK9999", true));
        System.out.println("\nBK9999 Added Successfully.");

        removeBySerial(items, itemsBySerial, SERIAL_TO_REMOVE);

        searchLinear(items, SERIAL_TO_SEARCH);
        searchByMap(itemsBySerial, SERIAL_TO_SEARCH);

        printComparison();
    }
    private static void populateBooks(List<Library_items> items, Set<String> authors, Map<String, Library_items> map) {
        for (int i = 1; i <= ITEM_COUNT; i++) {
            Book book = new Book("Book " + i, "Author " + (i % 20), String.format("BK%04d", i), i % 2 == 0);
            items.add(book);
            authors.add(book.getAuthor());
            map.put(book.getSr_no(), book);
        }
    }

    private static void populateNovels(List<Library_items> items, Set<String> authors, Map<String, Library_items> map) {
        for (int i = 1; i <= ITEM_COUNT; i++) {
            Novel novel = new Novel("Novel " + i, "Author " + (i % 20), String.format("NV%04d", i), i % 2 != 0);
            items.add(novel);
            authors.add(novel.getAuthor());
            map.put(novel.getSr_no(), novel);
        }
    }

    private static void printSummary(Library library, Set<String> authors) {
        System.out.println("Library       : " + library.getName());
        System.out.println("Total Items   : " + library.getList().size());
        System.out.println("Total Authors : " + authors.size());
    }

    private static void addBook(List<Library_items> items, Set<String> authors, Map<String, Library_items> map, Book book) {
        String serial = book.getSr_no();
        if (serial == null || serial.isBlank()) {
            throw new InvalidSerialException("Cannot add a book with a blank serial number.");
        }
        if (map.containsKey(serial)) {
            System.err.println("Skipping duplicate serial: " + serial + " already exists in the library.");
            return;
        }
        items.add(book);
        authors.add(book.getAuthor());
        map.put(serial, book);
    }

    private static void removeBySerial(List<Library_items> items, Map<String, Library_items> map, String serial) {
        if (serial == null || serial.isBlank()) {
            System.err.println("Cannot remove: serial number is missing.");
            return;
        }
        Library_items removed = map.remove(serial);
        if (removed != null) {
            items.remove(removed);
            System.out.println(serial + " Removed Successfully.");
        } else {
            System.err.println("Cannot remove: no item found with serial " + serial);
        }
    }

    private static void searchLinear(List<Library_items> items, String serial) {
        System.out.println("\nLinear Search:");
        if (serial == null || serial.isBlank()) {
            System.err.println("Cannot search: serial number is missing.");
            return;
        }
        for (Library_items item : items) {
            String itemSerial = (item instanceof Book b) ? b.getSr_no()
                    : (item instanceof Novel n) ? n.getSr_no() : null;
            if (serial.equals(itemSerial)) {
                item.ShowDetail();
                return;
            }
        }
        System.err.println("Item Not Found: " + serial);
    }

    private static void searchByMap(Map<String, Library_items> map, String serial) {
        System.out.println("\nHashMap Search:");
        if (serial == null || serial.isBlank()) {
            System.err.println("Cannot search: serial number is missing.");
            return;
        }
        Library_items result = map.get(serial);
        if (result != null) {
            result.ShowDetail();
        } else {
            System.err.println("Item Not Found: " + serial);
        }
    }
    private static void printComparison() {
        System.out.println("\nComparison:");
        System.out.println("1. ArrayList stores all library items and maintains insertion order.");
        System.out.println("2. HashSet stores unique author names and automatically removes duplicates.");
        System.out.println("3. HashMap stores serial numbers as keys, allowing much faster searching than an ArrayList.");
    }
}
