import java.util.Scanner;

public class replaceRepeatingChars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder input = new StringBuilder(console.nextLine());

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                input.deleteCharAt(i);
                i--;
            }
        }

        System.out.println(input);
    }
}
