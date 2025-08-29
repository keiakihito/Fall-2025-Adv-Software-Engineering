import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    // Each element can be a file or a directory
    private List<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            // It can be a file or a directory.
            // Calculate wtih a composite pattern by recursion.
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            // Print with a composite pattern by recursion.
            entry.printList(prefix + "/" + name);
        }
    }

    // ディレクトリエントリをディレクトリに追加する
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
