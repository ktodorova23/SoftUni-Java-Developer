import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
public class thePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String line = reader.readLine();

        while (!line.equals("Print")) {
            String[] tokens = line.split(";");

            switch (tokens[0]) {
                case "Add filter":

                    break;
                case "Remove filter":

                    break;
            }

            line = reader.readLine();
        }
    }
}
