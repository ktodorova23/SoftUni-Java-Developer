import java.util.Scanner;

public class integerOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num1 = Integer.parseInt(console.nextLine());
        int num2 = Integer.parseInt(console.nextLine());
        int num3 = Integer.parseInt(console.nextLine());
        int num4 = Integer.parseInt(console.nextLine());

        int result = num1 + num2;
        result /= num3;
        result *= num4;

        System.out.println(result);
    }
}
