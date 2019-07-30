package stackOfStrings;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        validateIfEmpty();
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        validateIfEmpty();
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    private void validateIfEmpty() {
        if (this.data.isEmpty()) {
            throw new InvalidParameterException("Stack is empty");
        }
    }
}
