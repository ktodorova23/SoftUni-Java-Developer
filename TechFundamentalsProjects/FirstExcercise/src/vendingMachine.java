import java.util.Scanner;

public class vendingMachine {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputText = console.nextLine();

        double coins = Double.parseDouble(inputText);

        double sum = 0;
        double priceNuts = 2.0;
        double priceWater = 0.7;
        double priceCrisps = 1.5;
        double priceSoda = 0.8;
        double priceCoke = 1.0;

        while (!inputText.equals("Start")) {
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum+=coins;
            } else {
                System.out.printf("Cannot accept %.2f", coins);
            }
            inputText = console.nextLine();
            coins = Double.parseDouble(inputText);
        }


    }
}
