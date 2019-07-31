import java.util.Scanner;

public class rageExpenses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(console.nextLine());
        double headsetPrice = Double.parseDouble(console.nextLine());
        double mousePrice = Double.parseDouble(console.nextLine());
        double keyboardPrice = Double.parseDouble(console.nextLine());
        double displayPrice = Double.parseDouble(console.nextLine());

        int brokenHeadsets = lostGamesCount / 2;
        int brokenMouses = lostGamesCount / 3;
        int brokenKeyboards = lostGamesCount / 6;
        int brokenDisplays = lostGamesCount / 12;

        double expenses = brokenHeadsets * headsetPrice + brokenMouses * mousePrice + brokenKeyboards * keyboardPrice + brokenDisplays * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
