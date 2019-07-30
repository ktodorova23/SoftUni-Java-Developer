package genericScale;

public class Scale <T extends Comparable<T>> {
    public T left;
    public T right;


    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.compareTo(right) > 0) {
            return left;
        } else if (left.compareTo(right) == 0) {
            return null;
        }

        return right;
    }
}
