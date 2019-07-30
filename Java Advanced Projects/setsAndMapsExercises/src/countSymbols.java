import java.util.Scanner;
import java.util.TreeMap;

public class countSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        TreeMap<Character, Integer> countBByLetters = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            countBByLetters.putIfAbsent(symbol, 0);
            countBByLetters.put(symbol, countBByLetters.get(symbol) + 1);
        }

//        t: 1 time/s
        for (Character character : countBByLetters.keySet()) {
            System.out.printf("%c: %d time/s%n", character, countBByLetters.get(character));
        }
    }
}
