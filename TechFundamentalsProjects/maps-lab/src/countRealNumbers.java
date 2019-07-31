import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class countRealNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> count = new TreeMap<>();

        for (double num : numbers) {
            count.putIfAbsent(num, 0);
            count.put(num, count.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> counts : count.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.########################");
            System.out.printf("%s -> %d%n", df.format(counts.getKey()), counts.getValue());
        }
    }
}
