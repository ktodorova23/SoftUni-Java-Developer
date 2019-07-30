import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class addVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        System.out.println("Prices with VAT:");
        Arrays.stream(input)
                .mapToDouble(Double::parseDouble)
                .map(d -> d * 1.2)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
