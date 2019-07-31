import java.util.InputMismatchException;
import java.util.Scanner;

public class strongNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int inputNumber = Integer.parseInt(console.nextLine());

        int result = 0;
        int digit = 0;
        int tempResult = 1;
        int number = inputNumber;

        while (number > 0) {
            digit = number % 10;
            for (int i = 1; i <= digit; i++) {
                tempResult*=i;
            }
            number = number / 10;
            result += tempResult;
            tempResult = 1;
        }

        if (inputNumber == result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
