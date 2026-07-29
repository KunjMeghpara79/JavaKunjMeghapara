public class Book implements Library_items, Comparable<Book> {

    private String title;
    private String author;
    private String sr_no;
    private boolean available;

    public Book(String title, String author, String sr_no, boolean available) {

        if (sr_no.length() != 6) {
            throw new IllegalArgumentException("Invalid Serial Number!");
        }

        this.title = title;
        this.author = author;
        this.sr_no = sr_no;
        this.available = available;
    }

    @Override
    public int compareTo(Book other) {
        return this.sr_no.compareTo(other.sr_no);
    }

    @Override
    public void ShowDetail() {
        System.out.println("Book Details are as follows...");
        System.out.println("Book Name      : " + title);
        System.out.println("Author Name    : " + author);
        System.out.println("Serial Number  : " + sr_no);
        System.out.println("Status         : " + (available ? "Available" : "Not Available"));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSr_no() {
        return sr_no;
    }

    public boolean isAvailable() {
        return available;
    }
}