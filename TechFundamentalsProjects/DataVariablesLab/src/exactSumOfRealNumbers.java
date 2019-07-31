import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class exactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int count = Integer.parseInt(console.nextLine());

        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < count; i++) {
            Double num = Double.parseDouble(console.nextLine());
            sum = sum.add(BigDecimal.valueOf(num));
        }

        DecimalFormat df = new DecimalFormat("#.######################################");

        System.out.println(df.format(sum));
    }
}
