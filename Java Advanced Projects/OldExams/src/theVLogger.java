import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class theVLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, List<String>> followedBy = new TreeMap<>();
        TreeMap<String, List<String>> following = new TreeMap<>();

        String line;
        while (!"Statistics".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            if (tokens[1].equals("joined")) {
                String name = tokens[0];
                followedBy.putIfAbsent(name, new ArrayList<>());
                following.putIfAbsent(name, new ArrayList<>());
            } else {
                String first = tokens[0];
                String second = tokens[2];
                if (followedBy.containsKey(first) && followedBy.containsKey(second) && !first.equals(second)) {
                    followedBy.get(second).add(first);
                    following.get(first).add(second);
                }
            }
        }

        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.", followedBy.size()));
        List<String> sortedNames = followedBy.keySet().stream()
                .sorted(Comparator.comparing((String a) -> followedBy.get(a).size(), Comparator.reverseOrder())
                        .thenComparing(a -> following.get(a).size()))
                .collect(Collectors.toList());

        int counter = 1;
        for (String name : sortedNames) {
            System.out.println(String.format("%d. %s : %d followers, %d following", counter, name, followedBy.get(name).size(), following.get(name).size()));
            if (counter == 1) {
                if (followedBy.get(name).size() != 0) {
                    Collections.sort(followedBy.get(name));
                    followedBy.get(name).forEach(e -> System.out.println(String.format("*  %s", e)));
                }
            }
            counter++;
        }

    }
}
