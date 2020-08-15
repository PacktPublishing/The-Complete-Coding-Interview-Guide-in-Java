package coding.challenge.filesystem;
 
import java.util.ArrayList;
import java.util.List;

public class Directory extends Item {

    protected List<Item> items;
    
    public Directory(String name, Directory parent) {

        super(name, parent);

        items = new ArrayList<>();        
    }

    @Override
    public long size() { return 0; }
        
    public int countFiles() { return 0; }

    protected boolean deleteItem(Item item) { return false; }
    protected void addEntry(Item item) {}
    protected List<Item> getItems() { return null; }
}
