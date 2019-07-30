import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> passwordsByContests = new HashMap<>();

        String line;

        while (!"end of contests".equals(line = reader.readLine())) {
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String password = tokens[1];

            passwordsByContests.putIfAbsent(contest, password);
        }

        HashMap<String, HashMap<String, Integer>> contestsResultsByUser = new HashMap<>();

        while (!"end of submissions".equals(line = reader.readLine())) {
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (passwordsByContests.containsKey(contest)) {
                if (passwordsByContests.get(contest).equals(password)) {
                    if (!contestsResultsByUser.containsKey(username)) {
                        contestsResultsByUser.put(username, new HashMap<>());
                        contestsResultsByUser.get(username).put(contest, points);
                    } else {
                        if (!contestsResultsByUser.get(username).containsKey(contest)) {
                            contestsResultsByUser.get(username).put(contest, points);
                        } else {
                            if (points > contestsResultsByUser.get(username).get(contest)) {
                                contestsResultsByUser.get(username).put(contest, points);
                            }
                        }
                    }
                }
            }
        }

        HashMap<String, Integer> totalPointsByUsers = new HashMap<>();

        for (String user : contestsResultsByUser.keySet()) {
            int points = 0;
            for (Map.Entry<String, Integer> contest: contestsResultsByUser.get(user).entrySet()) {
                points += contest.getValue();
            }
            totalPointsByUsers.put(user, points);
        }

        String topCandidate = "";
        int highestPoints = -1;
        for (Map.Entry<String, Integer> user : totalPointsByUsers.entrySet()) {
            if (user.getValue() > highestPoints) {
                highestPoints = user.getValue();
                topCandidate = user.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", topCandidate, totalPointsByUsers.get(topCandidate));
        System.out.println("Ranking: ");
        contestsResultsByUser.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(c -> System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue()));
        });
    }
}
