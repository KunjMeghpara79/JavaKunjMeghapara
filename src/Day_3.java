import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day_3 {

    public static void main(String[] args) {

        ArrayList<lib_items> list = new ArrayList<>();
        HashSet<String> authors = new HashSet<>();
        HashMap<String, lib_items> map = new HashMap<>();

        Library lib = new Library("Public Library", list);

        for (int i = 1; i <= 250; i++) {

            Book b = new Book(
                    "Book " + i,
                    "Author " + (i % 20),
                    String.format("BK%04d", i),
                    i % 2 == 0
            );

            list.add(b);
            authors.add(b.getAuthor());
            map.put(b.getSr_no(), b);
        }

        for (int i = 1; i <= 250; i++) {

            Novel n = new Novel(
                    "Novel " + i,
                    "Author " + (i % 20),
                    String.format("NV%04d", i),
                    i % 2 != 0
            );

            list.add(n);
            authors.add(n.getAuthor());
            map.put(n.getSr_no(), n);
        }

        System.out.println("Library : Public Library");
        System.out.println("Total Items : " + list.size());
        System.out.println("Unique Authors : " + authors.size());

        Book newBook = new Book(
                "Atomic Habits",
                "James Clear",
                "BK9999",
                true
        );

        list.add(newBook);
        authors.add(newBook.getAuthor());
        map.put(newBook.getSr_no(), newBook);

        System.out.println("\nBK9999 Added Successfully.");

        lib_items removed = map.remove("BK0100");

        if (removed != null) {
            list.remove(removed);
            System.out.println("BK0100 Removed Successfully.");
        }


        String search = "NV0200";
        boolean found = false;

        /*
         * Slow Search (O(n))
         * Checks every item one by one.
         * Faster way: Use HashMap because searching by key
         * takes O(1) time on average.
         */

        System.out.println("\nLinear Search:");

        for (lib_items item : list) {

            if (item instanceof Book) {

                Book b = (Book) item;

                if (b.getSr_no().equals(search)) {
                    b.ShowDetail();
                    found = true;
                    break;
                }

            } else if (item instanceof Novel) {

                Novel n = (Novel) item;

                if (n.getSr_no().equals(search)) {
                    n.ShowDetail();
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Item Not Found");
        }

        System.out.println("\nHashMap Search:");

        lib_items result = map.get(search);

        if (result != null) {
            result.ShowDetail();
        } else {
            System.out.println("Item Not Found");
        }


        System.out.println("\nComparison:");
        System.out.println("1. ArrayList stores all library items and maintains insertion order.");
        System.out.println("2. HashSet stores unique author names and automatically removes duplicates.");
        System.out.println("3. HashMap stores serial numbers as keys, allowing much faster searching than an ArrayList.");
    }
}