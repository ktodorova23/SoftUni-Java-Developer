import java.util.*;

public class wordSynonyms {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = console.nextLine();
            String synonym = console.nextLine();

            synonyms.putIfAbsent(word, new ArrayList<>());
            List<String> synonymsByWord = synonyms.get(word);
            synonymsByWord.add(synonym);
        }


        synonyms.forEach((word, synonymsByWord) -> { System.out.print(word + " - ");
        System.out.println(String.join(", ", synonymsByWord));});
    }
}
