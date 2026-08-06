public class Book implements LibraryItems, Comparable<Book> {

    private String title;
    private String author;
    private String srNo;
    private boolean available;

    public Book(String title, String author, String srNo, boolean available) throws LibraryDataException {
        if(title == null || author == null || srNo == null ){
            throw new LibraryDataException("Data can not be null");
        }
        if (srNo.length() != 6) {
            throw new InvalidSerialException("Invalid Serial Number!");
        }


        this.title = title;
        this.author = author;
        this.srNo = srNo;
        this.available = available;
    }

    @Override
    public int compareTo(Book other) {
        return this.srNo.compareTo(other.srNo);
    }

    @Override
    public void ShowDetail() {
        System.out.println("Book Details are as follows...");
        System.out.println("Book Name      : " + title);
        System.out.println("Author Name    : " + author);
        System.out.println("Serial Number  : " + srNo);
        System.out.println("Status         : " + (available ? "Available" : "Not Available"));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSr_no() {
        return srNo;
    }

    public boolean isAvailable() {
        return available;
    }

}