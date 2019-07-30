import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class filterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        HashMap<String, Integer> ageByName = new HashMap<>();

        while (lines-- > 0) {
            String[] tokens = reader.readLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            ageByName.putIfAbsent(name, age);
        }

        String filter = reader.readLine();


        switch (filter) {
            case "older":
                break;
                default:
                    break;
        }
    }
}
