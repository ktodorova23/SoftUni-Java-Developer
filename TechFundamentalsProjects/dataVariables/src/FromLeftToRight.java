import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int lines = Integer.parseInt(console.nextLine());

        for (int i = 0; i < lines; i++) {
            String numbers = console.nextLine();
            String[] separated = numbers.split("[ ]");
            long firstNum = Long.parseLong(separated[0]);
            long secondNum = Long.parseLong(separated[1]);

            long sum = 0;
            long greaterNum = firstNum;

            if (secondNum > firstNum) {
                greaterNum = secondNum;
            }

            while (greaterNum != 0) {
                long digit = Math.abs(greaterNum % 10);
                sum += digit;
                greaterNum /= 10;
            }
            System.out.println(sum);
        }
    }
}
