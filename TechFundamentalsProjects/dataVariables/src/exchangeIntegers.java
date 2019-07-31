import java.util.Scanner;

public class exchangeIntegers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num1 = Integer.parseInt(console.nextLine());
        int num2 = Integer.parseInt(console.nextLine());

        System.out.printf("Before:%na = %d%nb = %d%nAfter:%na = %d%nb = %d", num1, num2, num2, num1);
    }
}
