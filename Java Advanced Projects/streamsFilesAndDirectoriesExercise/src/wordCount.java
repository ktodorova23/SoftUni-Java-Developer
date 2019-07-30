import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class wordCount {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("words.txt");
        FileInputStream resourseFileStream = new FileInputStream("text.txt");
        PrintWriter writer = new PrintWriter("results.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));

        HashMap<String, Integer> countsByWords = new HashMap<>();
        String[] words = reader.readLine().split("\\s+");

        for (String word : words) {
            countsByWords.putIfAbsent(word, 0);
        }

        reader = new BufferedReader(new InputStreamReader(resourseFileStream));

        String line = reader.readLine();

        while (line != null) {
            String[] tokens = line.split("\\s+");

            for (int i = 0; i < tokens.length; i++) {
                if (countsByWords.containsKey(tokens[i])) {
                    countsByWords.put(tokens[i], countsByWords.get(tokens[i]) + 1);
                }
            }

            line = reader.readLine();
        }

        countsByWords.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(w -> writer.println(w.getKey() + " - " + w.getValue()));
        writer.close();
    }
}
