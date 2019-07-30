package listyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator() {
        this.data = new ArrayList<>();
    }

    public List<String> getData() {
        return this.data;
    }


    public void add(String element) {
        this.data.add(element);
    }

    public boolean move() {
        if (this.index + 1 < this.data.size()){
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.data.size() == 0) {
            return false;
        }
        return this.index != this.data.size() - 1;
    }

    public String print() {
        if (index >= this.data.size() || index < 0) {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        return this.data.get(index);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < data.size() - 1;
            }

            @Override
            public String next() {
                return data.get(this.index++);
            }
        };
    }
}
