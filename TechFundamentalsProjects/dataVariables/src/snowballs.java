import java.math.BigInteger;
import java.util.Scanner;

public class snowballs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = Integer.parseInt(console.nextLine());

        double highestValue = Double.MIN_VALUE;
        int snow = 0, time = 0, quality = 0;

        for (int i = 0; i < N; i++) {
            int snowballSnow = Integer.parseInt(console.nextLine());
            int snowballTime = Integer.parseInt(console.nextLine());
            int snowballQuality = Integer.parseInt(console.nextLine());

            double value = Math.pow(snowballSnow / snowballTime, snowballQuality);

            if (value > highestValue) {
                highestValue = value;
                snow = snowballSnow;
                time = snowballTime;
                quality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", snow, time, highestValue, quality);

    }
}
