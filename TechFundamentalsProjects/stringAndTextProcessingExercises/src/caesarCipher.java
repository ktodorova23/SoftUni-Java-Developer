import java.util.Scanner;

public class caesarCipher {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result.append((char) (input.charAt(i) + 3));
        }

        System.out.println(result);
    }
}
