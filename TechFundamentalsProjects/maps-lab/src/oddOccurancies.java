import java.util.*;

public class oddOccurancies {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] words = console.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word: words){
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }

        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i <odds.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
