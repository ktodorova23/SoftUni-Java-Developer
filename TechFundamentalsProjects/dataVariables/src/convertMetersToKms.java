import java.util.Scanner;

public class convertMetersToKms {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int meters = Integer.parseInt(console.nextLine());

        double kms = (double) meters / 1000;

        System.out.printf("%.2f", kms);
    }
}
