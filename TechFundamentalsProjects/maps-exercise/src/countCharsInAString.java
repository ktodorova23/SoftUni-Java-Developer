import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class countCharsInAString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String word = console.nextLine().replaceAll("\\s+", "");

        Map<Character, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {
            count.putIfAbsent(word.charAt(i), 0);
            count.put(word.charAt(i), count.get(word.charAt(i)) + 1);
        }

        for (Map.Entry<Character, Integer> entry:count.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
