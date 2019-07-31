import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String product = console.nextLine();
        int quantity = Integer.parseInt(console.nextLine());

        printResult(product, quantity);
    }

    private static void printResult(String product, int quantity) {
        double pricePerUnit = -1;
        switch (product) {
            case "coffee":
                pricePerUnit = 1.50;
                break;
            case "water":
                pricePerUnit = 1.00;
                break;
            case "coke":
                pricePerUnit = 1.40;
                break;
            case "snacks":
                pricePerUnit = 2.00;
                break;
        }

        double sum = quantity * pricePerUnit;

        System.out.printf("%.2f", sum);
    }
}
