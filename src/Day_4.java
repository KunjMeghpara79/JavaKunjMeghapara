import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day_4 {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        for (int i = 1; i <= 250; i++) {

            books.add(new Book("Book " + i, "Author " + (i % 20), String.format("BK%04d", i), i % 2 == 0));
        }

        Map<String, List<Book>> map = new HashMap<>();

        for (Book b : books) {

            map.putIfAbsent(b.getAuthor(), new ArrayList<>());

            map.get(b.getAuthor()).add(b);
        }

        System.out.println("========== GROUPED BY AUTHOR ==========\n");

        for (Map.Entry<String, List<Book>> entry : map.entrySet()) {

            System.out.println(entry.getKey());

            System.out.println("Total Books : " + entry.getValue().size());

            System.out.println();
        }


        Collections.sort(books);
        //sorted by serial numbers

        for (int i = 0; i < 10; i++) {

            books.get(i).ShowDetail();
        }

        // sorted by title
        books.sort(new TitleComparator());



        for (int i = 0; i < 10; i++) {

            books.get(i).ShowDetail();
        }

        // sorted by their author's name

        books.sort(new AuthorComparator());

        for (int i = 0; i < 10; i++) {

            books.get(i).ShowDetail();
        }
    }
}

class TitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {

        return b1.getTitle().compareTo(b2.getTitle());
    }
}

class AuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {

        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}