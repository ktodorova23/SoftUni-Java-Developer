import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class customMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> nums = new ArrayList<>();
        Arrays.stream(numbers).forEach(nums::add);
        int min = Collections.min(nums);

        System.out.println(min);
    }
}
