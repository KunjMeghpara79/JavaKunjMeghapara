import java.util.List;

public class Library {

    private String name;
    private List<Library_items> list;

    public Library(String name, List<Library_items> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public List<Library_items> getList() {
        return list;
    }

    public void addItem(Library_items item) {
        list.add(item);
    }
}