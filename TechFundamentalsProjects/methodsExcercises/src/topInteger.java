import java.util.Scanner;

public class topInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        for (int i = 1; i < n; i++) {
            int operationNum = i;
            int digitsSum = 0;
            boolean hasOddNum = false;

            while (operationNum > 0) {
                int lastDigit = operationNum % 10;

                if(lastDigit % 2 != 0) {
                    hasOddNum = true;
                }
                digitsSum += lastDigit;
                operationNum = operationNum / 10;
            }

            int result = -1;

            if (digitsSum % 8 == 0 && hasOddNum) {
                result = i;
            }
            if (result != -1) {
                System.out.println(result);

            }
        }
    }
}
