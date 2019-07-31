import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Map<String, Double> prices = new LinkedHashMap<>();
        Map<String, Integer> quantities = new LinkedHashMap<>();
        Map<String, Double> finalNumbers = new LinkedHashMap<>();

        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            prices.putIfAbsent(product, 0d);
            prices.put(product, price);
            quantities.putIfAbsent(product, 0);
            quantities.put(product, quantities.get(product) + quantity);
            finalNumbers.putIfAbsent(product, 0d);
            line = console.nextLine();
        }

        for (Map.Entry<String, Double> entry:finalNumbers.entrySet()) {
            finalNumbers.put(entry.getKey(), (prices.get(entry.getKey()) * quantities.get(entry.getKey())));
        }

        finalNumbers.forEach((key, value) -> {
            System.out.print(key + " -> ");
            System.out.printf("%.2f%n", value);
        });
    }
}
