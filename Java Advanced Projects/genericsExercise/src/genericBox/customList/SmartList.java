package genericBox.customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class SmartList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> data;

    public SmartList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.data, firstIndex, secondIndex);
    }

    public int greaterThat(T element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).toArray().length;
    }

    public T max() {
        return this.data.stream().max(T::compareTo).get();
    }

    public T min() {
        return this.data.stream().min(T::compareTo).get();
    }

    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(this.index++);
            }
        };
    }
}
