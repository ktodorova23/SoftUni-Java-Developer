import java.text.DecimalFormat;
import java.util.Scanner;

public class mathOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double firstNumber = Double.parseDouble(console.nextLine());
        char operator = console.nextLine().charAt(0);
        double secondNumber = Double.parseDouble(console.nextLine());

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(calculateResult(firstNumber, operator, secondNumber)));

    }

    private static double calculateResult(double firstNumber, char operator, double secondNumber) {
        double result = 0;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
        }
        return result;
    }
}
