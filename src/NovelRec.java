record NovelRec(String title, String author, String serialNo, boolean available) implements LibraryItems {

    public NovelRec {
        if (serialNo.length() != 6) {
            throw new IllegalArgumentException("Invalid Serial Number!");
        }
    }

    @Override
    public void ShowDetail() {
        System.out.println("Novel Details");
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Serial No   : " + serialNo);
        System.out.println("Status      : " + (available ? "Available" : "Not Available"));

    }
}