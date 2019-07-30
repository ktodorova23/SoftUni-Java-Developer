import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class footballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<String>> results = new LinkedHashMap<>();

        String line;
        while (!"Season End".equals(line = reader.readLine())) {
            String[] data = line.split(" result ");
            String[] teams = data[0].split(" - ");
            String homeTeam = teams[0];
            String guestTeam = teams[1];

            results.putIfAbsent(homeTeam, new ArrayList<>());
            results.putIfAbsent(guestTeam, new ArrayList<>());
            results.get(homeTeam).add(guestTeam + " -> " + data[1]);
            results.get(guestTeam).add(homeTeam + " -> " + new StringBuilder(data[1]).reverse().toString());
        }

        String[] teamsToPrint = reader.readLine().split(", ");

        for (String team : teamsToPrint) {
            results.get(team)
                    .stream()
                    .sorted(Comparator.comparing(e -> e.split(" -> ")[0]))
                    .forEach(e -> System.out.println(team + " - " + e));
        }
    }
}
