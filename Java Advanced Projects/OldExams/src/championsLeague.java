import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class championsLeague {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> wins = new TreeMap<>();
        TreeMap<String, List<String>> opponents = new TreeMap<>();

        String line;

        while (!"stop".equals(line = reader.readLine())) {
            String[] tokens = line.split(" \\| ");

            String firstTeam = tokens[0];
            String secondTeam = tokens[1];

            wins.putIfAbsent(firstTeam, 0);
            wins.putIfAbsent(secondTeam, 0);

            opponents.putIfAbsent(firstTeam, new ArrayList<>());
            opponents.get(firstTeam).add(secondTeam);

            opponents.putIfAbsent(secondTeam, new ArrayList<>());
            opponents.get(secondTeam).add(firstTeam);

            int firstTeamScores = Integer.parseInt(tokens[2].split(":")[0]) +
                    Integer.parseInt(tokens[3].split(":")[1]);

            int secondTeamScores = Integer.parseInt(tokens[2].split(":")[1]) +
                    Integer.parseInt(tokens[3].split(":")[0]);

            String winningTeam = "";
            if (firstTeamScores == secondTeamScores) {
                int firstTeamAwayPoints = Integer.parseInt(tokens[3].split(":")[1]);
                int secondTeamAwayPoints = Integer.parseInt(tokens[2].split(":")[1]);
                if (firstTeamAwayPoints > secondTeamAwayPoints) {
                    winningTeam = firstTeam;
                } else {
                    winningTeam = secondTeam;
                }
//                if (Integer.parseInt(tokens[2].split(":")[0]) > Integer.parseInt(tokens[2].split(":")[1])) {
//                    winningTeam = firstTeam;
//                } else if (Integer.parseInt(tokens[2].split(":")[0]) == Integer.parseInt(tokens[2].split(":")[1])){
//                    if (Integer.parseInt(tokens[2].split(":")[0]) > Integer.parseInt(tokens[3].split(":")[0])) {
//                        winningTeam = firstTeam;
//                    } else {
//                        winningTeam = secondTeam;
//                    }
//                } else {
//                    winningTeam = secondTeam;
//                }
            } else if (firstTeamScores > secondTeamScores) {
                winningTeam = firstTeam;
            } else {
                winningTeam = secondTeam;
            }

            wins.put(winningTeam, wins.get(winningTeam) + 1);
        }

        wins.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("- Wins: " + e.getValue());
                    Collections.sort(opponents.get(e.getKey()));
                    System.out.println("- Opponents: " + String.join(", ", opponents.get(e.getKey())));
                });
    }
}
