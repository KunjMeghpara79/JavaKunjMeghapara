import java.util.List;

class LibraryRec {
    private String name;
    private List<LibraryItems> items;

    LibraryRec(String name, List<LibraryItems> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<LibraryItems> getItems() {
        return items;
    }
}