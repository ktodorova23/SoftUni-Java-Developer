import java.util.Arrays;
import java.util.Scanner;

public class sumMatrixElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[]info = console.nextLine().split(", ");
        int rows = Integer.parseInt(info[0]);
        int cols = Integer.parseInt(info[1]);

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            sum += Arrays.stream(console.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
