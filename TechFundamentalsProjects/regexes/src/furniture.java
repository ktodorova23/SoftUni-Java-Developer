import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class furniture {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        double moneySpent = 0;
        List<String> furnituresBought = new ArrayList<>();

        while (!input.equals("Purchase")) {

            String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                if (quantity != 0 && price != 0) {
                    moneySpent += price * quantity;
                    furnituresBought.add(furniture);
                }

            }

            input = console.nextLine();
        }

        System.out.println("Bought furniture:");
        furnituresBought.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", moneySpent);

    }
}
