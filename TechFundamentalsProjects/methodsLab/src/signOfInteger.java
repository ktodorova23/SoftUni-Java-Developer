import java.util.Scanner;

public class signOfInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());

        findIntegerSign(number);
    }

    public static void findIntegerSign(int number) {
        if (number < 0) {
            System.out.println("The number " + number + " is negative.");
        } else if (number == 0) {
            System.out.println("The number 0 is zero.");
        } else {
            System.out.println("The number " + number + " is positive.");
        }
    }
}
