import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class handScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> values = new HashMap<>();
        for (int i = 2; i < 10; i++) {
            values.put((char) (i + '0'), i);
        }
        values.put('J', 12);
        values.put('Q', 13);
        values.put('K', 14);
        values.put('A', 15);

        String[] hand = reader.readLine().split(" ");

        int sum = 0;
        int length = 1;
        int tempSum = 0;
        char oldSuit = '-';
        for (String card : hand) {
            int value = card.length() == 3 ? 10 : values.get(card.charAt(0));
            char suit = card.length() == 3 ? card.charAt(2) : card.charAt(1);

            if (suit == oldSuit) {
                tempSum += value;
                length++;
            } else {
                sum += tempSum * length;
                length = 1;
                tempSum = value;
                oldSuit = suit;
            }
        }
        sum += tempSum * length;
        System.out.println(sum);
    }
}
