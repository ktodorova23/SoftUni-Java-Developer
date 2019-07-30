import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("Duplicates")
public class findTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::add);

        int minValue = Collections.min(numbers);
        int index = numbers.lastIndexOf(minValue);


        System.out.println(index);
    }
}
