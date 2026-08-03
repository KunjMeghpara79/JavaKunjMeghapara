import java.util.List;

class LibraryRec {
    private String name;
    private List<LibrarItems> items;

    LibraryRec(String name, List<LibrarItems> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<LibrarItems> getItems() {
        return items;
    }
}