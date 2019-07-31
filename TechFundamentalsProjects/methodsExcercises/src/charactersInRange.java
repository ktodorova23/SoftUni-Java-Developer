import java.util.Scanner;

public class charactersInRange {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char firstChar = console.nextLine().charAt(0);
        char secondChar = console.nextLine().charAt(0);

        getCharsInRange(firstChar, secondChar);
    }

    static void getCharsInRange (char first, char second) {
        for (char symbol = (char) (Math.min(first, second) + 1); symbol < Math.max(first, second); symbol++) {
            System.out.print(symbol + " ");
        }
    }
}
