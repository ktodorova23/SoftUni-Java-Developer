import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class listOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        int[] sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean passesTests = true;
        for (int i = 1; i <= number; i++) {
            for (int element : sequence) {
                if (i % element != 0) {
                    passesTests = false;
                    break;
                }
            }
            if (passesTests) {
                System.out.print(i + " ");
            } else {
                passesTests = true;
            }
        }
    }
}
