import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cubicRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(reader.readLine());

        long totalCells = 0;
        long hitsTaken = 0;
        String line;
        while (!"Analyze".equals(line = reader.readLine())) {
            int[] tokens = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (tokens[0] >= 0 && tokens[1] >= 0 && tokens[2] >= 0 &&
                    tokens[0] < n && tokens[1] < n && tokens[2] < n &&
            tokens[3] != 0) {
                totalCells += tokens[3];
                hitsTaken++;
            }
        }

        System.out.println(totalCells);
        System.out.println(n * n * n - hitsTaken);
    }
}
