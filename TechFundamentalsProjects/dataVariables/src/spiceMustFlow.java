import java.util.Scanner;

public class spiceMustFlow {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int startingYield = Integer.parseInt(console.nextLine());

        int input = startingYield;
        int tempYield = startingYield;
        int count = 0;
        int totalYield = 0;

        while (startingYield >= 100) {
            count++;
            totalYield += startingYield - 26;
            startingYield -= 10;
        }
        if (input >= 100) {
            totalYield -= 26;
        }

        System.out.printf("%d%n%d", count, totalYield);
    }
}
