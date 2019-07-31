import java.util.Scanner;

public class factorialDivision {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double firstNum =  Integer.parseInt(console.nextLine());
        double secondNum = Integer.parseInt(console.nextLine());

        double result = findFactorial(firstNum) / findFactorial(secondNum);

        System.out.println(String.format("%.2f", result));
    }

    public static double findFactorial (double n) {
        double factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }

        if(n == 0) {
            factorial = 1;
        }

        return factorial;
    }
}
