import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class predicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());
        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        names.stream().filter(e -> e.length() <= length).forEach(System.out::println);
    }
}
