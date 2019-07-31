import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class softuniBarIncome {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();
        double totalSum = 0;
        while (!line.equals("end of shift")) {
        Pattern patternCust = Pattern.compile("%(?<customer>[A-Z][a-z]+)%");
        Matcher matcherCust = patternCust.matcher(line);

        Pattern patternProduct = Pattern.compile("<(?<product>\\w+)>");
        Matcher matcherProd = patternProduct.matcher(line);

        Pattern patternCount = Pattern.compile("\\|(?<count>-?\\d+)\\|");
        Matcher matcherCount = patternCount.matcher(line);

        Pattern patternPrice = Pattern.compile("(?<price>-?\\d+\\.?[\\d+]?(?=\\$))");
        Matcher matcherPrice = patternPrice.matcher(line);

        if ((matcherCust.find()) && (matcherProd.find())&& (matcherCount.find()) && (matcherPrice.find())) {
            String customer = matcherCust.group("customer");
            String product = matcherProd.group("product");
            double count = Double.parseDouble(matcherCount.group("count"));
            double price = Double.parseDouble(matcherPrice.group("price"));

            if (price > 0 && count > 0) {
           double sum = price * count;
            System.out.println(String.format("%s: %s - %.2f", customer, product, sum));
            totalSum += sum;
            }
        }
            line = console.nextLine();
        }

        System.out.println(String.format("Total income: %.2f", totalSum));

    }
}
