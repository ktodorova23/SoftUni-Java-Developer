import java.util.Scanner;

public class charsToString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char symbol1 = console.nextLine().charAt(0);
        char symbol2 = console.nextLine().charAt(0);
        char symbol3 = console.nextLine().charAt(0);

        System.out.println("" + symbol1 + symbol2 + symbol3);
    }
}
