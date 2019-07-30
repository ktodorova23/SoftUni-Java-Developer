package genericBox;

public class Box<T extends Comparable<T>> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }

    public int compareTo (Box<T> other) {
        return this.element.compareTo(other.element);
    }
}
