import java.util.Scanner;

public class oddNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        int sum = 0;

        for (int i = 1; i <= n * 2 - 1; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.println(i);
            }
        }
        System.out.printf("Sum: %d", sum);
    }
}
