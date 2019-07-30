import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("Duplicates")
public class appliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input).forEach(numbers::add);

        String line = reader.readLine();

        while (!line.equals("end")) {
            switch (line) {
                case "add":
                    IntStream.range(0, numbers.size()).forEach(i -> numbers.set(i, numbers.get(i) + 1));
                    break;
                case "multiply":
                    IntStream.range(0, numbers.size()).forEach(i -> numbers.set(i, numbers.get(i) * 2));
                    break;
                case "subtract":
                    IntStream.range(0, numbers.size()).forEach(i -> numbers.set(i, numbers.get(i) - 1));
                    break;
                case "print":
                    numbers.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }

            line = reader.readLine();
        }

    }
}
