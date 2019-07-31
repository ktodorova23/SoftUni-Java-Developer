import java.util.Scanner;

public class multiplyBigNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String firstNum = console.nextLine();
        int secondNum = Integer.parseInt(console.nextLine());

        int result = 0;
        StringBuilder resultNum = new StringBuilder();
        int currentNum = 0;

        for (int i = firstNum.length() - 1; i >= 0; i--) {
            String symbol = Character.toString(firstNum.charAt(i));
            int number = Integer.parseInt(symbol);
           result += number * secondNum;
                if (result < 10) {
                    resultNum.append(result);
                    result = 0;
                } else {
                    resultNum.append(result % 10);
                    result = result / 10;
                }
        }
        if (result > 0) {
            resultNum.append(result);
        }
        resultNum.reverse();

        while (resultNum.charAt(0) == '0') {
            resultNum.deleteCharAt(0);
            if (resultNum.length() == 1) {
                break;
            }
        }

        System.out.println(resultNum);
    }
}
