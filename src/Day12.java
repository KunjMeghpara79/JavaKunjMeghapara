import java.util.ArrayList;
import java.util.List;

public class Day12 {

    public static void main(String[] args) throws LibraryDataException {
        List<LibrarItems> items = new ArrayList<>();

        try {
            items.add(new Book(null, "James Clear", "BK101", true));
            items.add(new Book("48 Laws of Power", "Robert Greene", "BK1002", false));
            items.add(new Novel("The Diary of a CEO", "Steven Bartlett", "NV2001", true));
            items.add(new Novel("The Laws of Human Nature", "Robert Greene", "NV2002", false));
        } catch (InvalidSerialException e) {
            System.err.println("Failed to build library items: " + e.getMessage());
            throw e;
        }

        Library library = new Library("Public Library", items);
        printLibraryItems(library);
    }

    private static void printLibraryItems(Library library) {
        if (library == null || library.getList() == null) {
            System.err.println("Cannot print items: library or its item list is missing.");
            return;
        }
        System.out.println("===== " + library.getName() + " =====\n");
        for (LibrarItems item : library.getList()) {
            if (item == null) {
                System.err.println("Skipping a null item in the library list.");
                continue;
            }
            item.ShowDetail();
            System.out.println("------------------------------");
        }
    }
}
