import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> duels = new LinkedHashMap<>();
        Map<String, Long> scores = new LinkedHashMap<>();

        String line;

        while (!"osu!".equals(line = reader.readLine())) {
            String[] playersData = line.split("<->");
            String[] firstPlayerData = playersData[0].split("\\s+");
            String[] secondPlayerData = playersData[1].split("\\s+");

            String firstPlayer = firstPlayerData[1];
            long firstPlayerScores = Integer.parseInt(firstPlayerData[0]);
            String secondPlayer = secondPlayerData[0];
            long secondPlayerScores = Integer.parseInt(secondPlayerData[1]);

            duels.putIfAbsent(firstPlayer, new ArrayList<>());
            duels.putIfAbsent(secondPlayer, new ArrayList<>());
            scores.putIfAbsent(firstPlayer, 0l);
            scores.putIfAbsent(secondPlayer, 0l);

            duels.get(firstPlayer).add(secondPlayer + " <-> " + (firstPlayerScores - secondPlayerScores));
            scores.put(firstPlayer, scores.get(firstPlayer) + (firstPlayerScores - secondPlayerScores));

            duels.get(secondPlayer).add(firstPlayer + " <-> " + (secondPlayerScores - firstPlayerScores));
            scores.put(secondPlayer, scores.get(secondPlayer) + (secondPlayerScores - firstPlayerScores));
        }

        scores.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> {
                    System.out.println(e.getKey() + " - (" + e.getValue() + ")");
                    duels.get(e.getKey()).forEach(d -> System.out.println("*   " + d));
                });
    }
}
