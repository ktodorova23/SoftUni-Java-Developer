import java.util.Scanner;

public class sumDigits {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }

        System.out.println(sum);
    }
}
