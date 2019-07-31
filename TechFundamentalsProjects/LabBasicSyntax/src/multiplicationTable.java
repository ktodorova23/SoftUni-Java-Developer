import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            System.out.printf("%d X " + i + " = %d%n", n, result);
        }
    }
}
