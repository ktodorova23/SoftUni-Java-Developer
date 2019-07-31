import java.util.Scanner;

public class multiplicationTable2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        int m = Integer.parseInt(console.nextLine());

        if (m > 10) {
            System.out.printf("%d X %d = %d", n, m, n * m);
        }

        for (int i = m; i <= 10; i++) {
            int result = n * i;
            System.out.printf("%d X %d = %d%n", n, i, result);
        }
    }
}
