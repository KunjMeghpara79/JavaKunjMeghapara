import java.util.List;

class LibraryRec {
    private String name;
    private List<Library_items> items;

    LibraryRec(String name, List<Library_items> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<Library_items> getItems() {
        return items;
    }
}