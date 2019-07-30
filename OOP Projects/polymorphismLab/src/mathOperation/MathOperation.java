package mathOperation;

public class MathOperation {
    public int add(int first, int second) {
        return first + second;
    }

    public int add(int first, int second, int third) {
        return add(first, second) + third;
    }

    public int add(int first, int second, int third, int fourth) {
        return add(first, second, third) + fourth;
    }
}
