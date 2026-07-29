import java.util.ArrayList;
import java.util.List;




// use all the classes in the current folder and do the following tasks in the Day_4.java file

public class Day_1_2 {
    public static void main(String[] args) {
        List<Library_items> list = new ArrayList<>();

        Library lib = new Library("Public Library", list);

        Book b1 = new Book("Atomic Habits", "James Clear", "BK1001", true);
        Book b2 = new Book("48 Laws of power", "Robert Green", "BK1002", false);

        Novel n1 = new Novel("The diary of a CEO", "Steven Bartlett", "NV2001", true);
        Novel n2 = new Novel("The laws of human nature", "Robert Green", "NV2002", false);


        list.add(b1);
        list.add(b2);
        list.add(n1);
        list.add(n2);


        System.out.println("===== Library Items =====\n");

        for (Library_items item : list) {
            item.ShowDetail();
            System.out.println("----------------------------");
        }
    }
}
