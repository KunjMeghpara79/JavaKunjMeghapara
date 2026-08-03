import java.util.List;

public class Library {

    private String name;
    private List<LibraryItems> list;

    public Library(String name, List<LibraryItems> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public List<LibraryItems> getList() {
        return list;
    }

    public void addItem(LibraryItems item) {
        list.add(item);
    }
}