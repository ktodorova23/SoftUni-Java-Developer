import java.util.Scanner;

public class smallestOfThreeNums {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num1 = Integer.parseInt(console.nextLine());
        int num2 = Integer.parseInt(console.nextLine());
        int num3 = Integer.parseInt(console.nextLine());

        System.out.println(findSmallestNum(num1, num2, num3));
    }

    static int findSmallestNum(int num1, int num2, int num3) {
        int smallestNum1 = Math.min(num1, num2);
        int smallestNum = Math.min(smallestNum1, num3);

        return smallestNum;
    }

}
