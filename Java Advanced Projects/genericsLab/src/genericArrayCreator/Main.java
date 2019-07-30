package genericArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = ArrayCreator.create(String.class, 10, "word");
        System.out.println();
    }
}
