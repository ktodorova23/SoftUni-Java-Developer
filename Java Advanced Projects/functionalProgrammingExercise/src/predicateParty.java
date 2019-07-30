import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class predicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String line = reader.readLine();

        while (!line.equals("Party!")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Remove":
                    if (tokens[1].equals("StartsWith")) {
                        names.removeIf(e -> e.startsWith(tokens[2]));
                    } else if (tokens[1].equals("EndsWith")) {
                        names.removeIf(e -> e.endsWith(tokens[2]));
                    } else {
                        names.removeIf(e -> e.length() == Integer.parseInt(tokens[2]));
                    }
                    break;
                case "Double":
                    if (tokens[1].equals("StartsWith")) {
                        List<String> temps = new ArrayList<>();
                        for (String name : names) {
                            if (name.startsWith(tokens[2])) {
                                temps.add(name);
                            }
                        }
                        names.addAll(temps);
                    } else if (tokens[1].equals("EndsWith")) {
                        List<String> temps = new ArrayList<>();
                        for (String name : names) {
                            if (name.endsWith(tokens[2])) {
                                temps.add(name);
                            }
                        }
                        names.addAll(temps);
                    } else {
                        List<String> temps = new ArrayList<>();
                        for (String name : names) {
                            if (name.length() == Integer.parseInt(tokens[2])) {
                                temps.add(name);
                            }
                        }
                        names.addAll(temps);
                    }
                    break;
            }

            line = reader.readLine();
        }

        if (names.size() > 0) {
            Collections.sort(names);
            System.out.print(String.join(", ", names));
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
