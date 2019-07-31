import java.util.Scanner;

public class repStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] words = console.nextLine().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (String word:words) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                sb.append(word);
            }
        }

        System.out.println(sb);
    }
}
