import java.util.Scanner;

public class evenNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        while (n != 0) {
            boolean evenNum = n % 2 == 0;
            if (evenNum) {
                System.out.printf("The number is: %d", Math.abs(n));
                break;
            } else {
                System.out.println("Please write an even number.");
                n = Integer.parseInt(console.nextLine());
            }
        }
    }
}
