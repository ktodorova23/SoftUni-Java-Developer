import java.util.Scanner;

public class refactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());
        for (int i = 2; i <= number; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, prime);
        }
    }
}
