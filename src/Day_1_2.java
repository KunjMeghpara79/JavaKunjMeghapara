import java.util.ArrayList;
import java.util.List;

interface lib_items{
    void ShowDetail();
}

class Library{
    private String name;
    private List<lib_items> list;
    Library(String name,List<lib_items> list){
        this.name = name;
        this.list = list;
    }
}
class Book implements lib_items,Comparable<Book>{
    private String title;
    private String author;
    private String sr_no;
    private boolean available;

    @Override
    public int compareTo(Book other) {
        return this.getSr_no().compareTo(other.getSr_no());
    }

    Book(String title,String author,String sr_no,boolean available){
        if(sr_no.length() != 6){
            System.out.println("Invalid Serial number !");
        }else {
            this.title = title;
            this.author = author;
            this.sr_no = sr_no;
            this.available = available;
        }
    }
    @Override
    public void ShowDetail() {
        System.out.println("Book Details are as follows...");
        System.out.println("Book Name      :  "+this.title);
        System.out.println("Author name    :  "+this.author);
        System.out.println("Serial number  :  "+this.sr_no);
        System.out.println("Status         :  "+((this.available) ? "Available" : "Not available"));
    }

    public String getAuthor() {
        return this.author;
    }

    public String getSr_no() {
    return this.sr_no;
    }

    public String getTitle() {
        return this.title;
    }
}
class Novel implements lib_items{
    private String title;
    private String author;
    private String sr_no;
    private boolean available;

    Novel(String title,String author,String sr_no,boolean available){
        if(sr_no.length() != 6){
            System.out.println("Invalid Serial number !");
        }else {
            this.title = title;
            this.author = author;
            this.sr_no = sr_no;
            this.available = available;
        }
    }
    @Override
    public void ShowDetail() {
        System.out.println("Novel Details are as follows...");
        System.out.println("Novel Name      :  "+this.title);
        System.out.println("Author name     :  "+this.author);
        System.out.println("Serial number   :  "+this.sr_no);
        System.out.println("Status          :  "+((this.available) ? "Available" : "Not available"));
    }

    public String getSr_no() {
        return this.sr_no;
    }

    public String getAuthor() {
        return this.author;
    }
}
// use all the classes in the current folder and do the following tasks in the Day_4.java file

public class Day_1_2 {
    public static void main(String[] args) {
        List<lib_items> list = new ArrayList<>();

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

        for (lib_items item : list) {
            item.ShowDetail();
            System.out.println("----------------------------");
        }
    }
}