import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class kninghtsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        names.forEach(e -> System.out.println("Sir " + e));
    }
}
