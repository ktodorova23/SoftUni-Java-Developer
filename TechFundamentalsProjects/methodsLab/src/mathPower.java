import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class mathPower {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double num1 = Double.parseDouble(console.nextLine());
        double num2 = Double.parseDouble(console.nextLine());

        DecimalFormat df = new DecimalFormat("#.####################################");
        System.out.println(df.format(powerNumber(num1, num2)));

    }

    private static BigDecimal powerNumber(double num1, double num2) {

        return new BigDecimal(Math.pow(num1, num2));
    }
}
