package collectionhierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection implements Addable {
    private int maxSize;
    private List<String> items;

    public Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>();
    }

    protected List<String> getItems() {
        return this.items;
    }

    protected int size() {
        return this.items.size();
    }
}
