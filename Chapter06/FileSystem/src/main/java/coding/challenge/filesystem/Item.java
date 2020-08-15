package coding.challenge.filesystem;

import java.time.Instant;
 
public abstract class Item {

    protected long created;
    protected long updated;
    protected long accessed;
    protected String name;
    protected Directory parent;

    public Item(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.created = Instant.now().toEpochMilli();
        this.updated = created;
        this.accessed = created;
    }

    public boolean delete() {
        if (parent == null) {
            return false;
        }
        
        return parent.deleteItem(this);
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }
    
    public String rename(String newName) {
        this.name = newName;
        
        return newName;
    }

    public abstract long size();
}
