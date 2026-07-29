import java.util.ArrayList;
import java.util.List;

public class Day_1_2 {

    public static void main(String[] args) {
        List<Library_items> items = new ArrayList<>();
        Library library = new Library("Public Library", items);

        items.add(new Book("Atomic Habits", "James Clear", "BK1001", true));
        items.add(new Book("48 Laws of Power", "Robert Greene", "BK1002", false));
        items.add(new Novel("The Diary of a CEO", "Steven Bartlett", "NV2001", true));
        items.add(new Novel("The Laws of Human Nature", "Robert Greene", "NV2002", false));

        printLibraryItems(library);
    }

    private static void printLibraryItems(Library library) {
        System.out.println("===== " + library.getName() + " =====\n");
        for (Library_items item : library.getList()) {
            item.ShowDetail();
            System.out.println("------------------------------");
        }
    }
}
