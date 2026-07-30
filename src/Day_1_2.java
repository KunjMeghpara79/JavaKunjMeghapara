import java.util.ArrayList;
import java.util.List;

public class Day_1_2 {

    public static void main(String[] args) {
        List<Library_items> items = new ArrayList<>();
        Library library = new Library("Public Library", items);

        try {
            items.add(new Book("Atomic Habits", "James Clear", "BK1001", true));
            items.add(new Book("48 Laws of Power", "Robert Greene", "BK1002", false));
            items.add(new Novel("The Diary of a CEO", "Steven Bartlett", "NV2001", true));
            items.add(new Novel("The Laws of Human Nature", "Robert Greene", "NV2002", false));
        } catch (InvalidSerialException e) {
            System.err.println("Failed to build library items: " + e.getMessage());
            throw e;
        }

        printLibraryItems(library);
    }

    private static void printLibraryItems(Library library) {
        if (library == null || library.getList() == null) {
            System.err.println("Cannot print items: library or its item list is missing.");
            return;
        }
        System.out.println("===== " + library.getName() + " =====\n");
        for (Library_items item : library.getList()) {
            if (item == null) {
                System.err.println("Skipping a null item in the library list.");
                continue;
            }
            item.ShowDetail();
            System.out.println("------------------------------");
        }
    }
}
