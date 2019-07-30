package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> identifiables = new ArrayList<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[1], tokens[0]);
                identifiables.add(robot);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                identifiables.add(citizen);
            }
        }

        line = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(line)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
