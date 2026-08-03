record BookRec(String title, String author, String serialNo, boolean available) implements LibraryItems, Comparable<BookRec> {

    public BookRec {
        if (serialNo.length() != 6) {
            throw new IllegalArgumentException("Invalid Serial Number!");
        }
    }

    @Override
    public void ShowDetail() {
        System.out.println("Book Details");
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Serial No   : " + serialNo);
        System.out.println("Status      : " + (available ? "Available" : "Not Available"));
    }

    @Override
    public int compareTo(BookRec other) {
        return serialNo.compareTo(other.serialNo);
    }
}