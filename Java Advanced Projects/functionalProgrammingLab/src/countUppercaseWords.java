import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class countUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> uppercaseWordOrNot = e -> e.charAt(0) == e.toUpperCase().charAt(0);

        List<String> words = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        int count = 0;

        for (int i = 0; i < words.size(); i++) {
            if (uppercaseWordOrNot.test(words.get(i))) {
                count++;
            } else {
                words.remove(words.get(i));
                i--;
            }
        }

        System.out.println(count);
        words.forEach(System.out::println);
    }
}
