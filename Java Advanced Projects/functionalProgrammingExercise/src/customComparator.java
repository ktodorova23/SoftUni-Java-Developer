import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class customComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> {
                    if (e % 2 == 0) {
                        evenNumbers.add(e);
                    } else {
                        oddNumbers.add(e);
                    }
                });

        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);

        evenNumbers.forEach(e -> System.out.print(e + " "));
        oddNumbers.forEach(e -> System.out.print(e + " "));
    }
}
