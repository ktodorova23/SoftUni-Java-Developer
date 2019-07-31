import java.util.Scanner;

public class printNumsInReverseOrder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int range = Integer.parseInt(console.nextLine());

        int[] numbers = new int[range];

        for (int i = 0; i < range; i++) {
            int number = Integer.parseInt(console.nextLine());

            numbers[i] = number;
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");

        }
        System.out.println();
    }
}
