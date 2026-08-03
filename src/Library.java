import java.util.List;

public class Library {

    private String name;
    private List<LibrarItems> list;

    public Library(String name, List<LibrarItems> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public List<LibrarItems> getList() {
        return list;
    }

    public void addItem(LibrarItems item) {
        list.add(item);
    }
}