import java.util.Scanner;

public class dollarsToPounds {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int pounds = Integer.parseInt(console.nextLine());

        double dollars = pounds * 1.31;

        System.out.printf("%.3f", dollars);
    }
}
