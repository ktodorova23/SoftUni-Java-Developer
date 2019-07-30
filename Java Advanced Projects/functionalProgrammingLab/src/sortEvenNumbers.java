import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class sortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = new ArrayList<>();

        int[] input = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(input).forEach(numbers::add);

        numbers.removeIf(e -> e % 2 != 0);
        printList(numbers);
        Collections.sort(numbers);
        printList(numbers);


    }

    private static void printList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.size() - 1) {
                System.out.print(numbers.get(i) + ", ");
            } else {
                System.out.println(numbers.get(i));
            }
        }
    }
}
