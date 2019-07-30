package defineAnInterfacePerson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        Map<String, Buyer> people = new HashMap<>();
        while (lines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            if (tokens.length == 3) {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                people.put(tokens[0], rebel);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                people.put(tokens[0], citizen);
            }
        }

        String line;
        while (!"End".equals(line = reader.readLine())) {
            if (people.containsKey(line)) {
                people.get(line).buyFood();
            }
        }

        int totalFoodBought = 0;
        for (Map.Entry<String, Buyer> entry : people.entrySet()) {
            totalFoodBought += entry.getValue().getFood();
        }

        System.out.println(totalFoodBought);
    }
}
