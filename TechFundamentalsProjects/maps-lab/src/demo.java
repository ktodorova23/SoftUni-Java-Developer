import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] row = console.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word:row) {
            counts.putIfAbsent(word, 0);
            counts.put(word, counts.get(word) + 1);
        }

        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry:counts.entrySet()) {
            if (entry.getValue()%2 ==1) {
                odds.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", odds));
    }
}
