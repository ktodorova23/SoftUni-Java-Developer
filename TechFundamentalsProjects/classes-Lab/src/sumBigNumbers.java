import java.math.BigInteger;
import java.util.Scanner;

public class sumBigNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(console.nextLine());
        BigInteger secondNum = new BigInteger(console.nextLine());

        BigInteger sum = firstNum.add(secondNum);

        System.out.println(sum);
    }
}
