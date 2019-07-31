import java.util.Scanner;

public class addAndSubtract {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int firstNum = Integer.parseInt(console.nextLine());
        int secondNum = Integer.parseInt(console.nextLine());
        int thirdNum = Integer.parseInt(console.nextLine());

        System.out.println(subtractThirdNum(firstNum, secondNum, thirdNum));
    }

    static int sumFirstTwoNums (int a, int b) {
//        int sum = a + b;

        return a + b;
    }

    static int subtractThirdNum (int a, int b, int c) {
        return sumFirstTwoNums(a, b) - c;
    }
}
