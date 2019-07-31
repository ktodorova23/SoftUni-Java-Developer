import java.util.Scanner;

public class sumEvenNums {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] array = console.nextLine().split(" ");

        int[] numArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            numArray[i] = Integer.parseInt(array[i]);
        }

        int sum = 0;

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 == 0) {
                sum += numArray[i];
            }
        }

        System.out.println(sum);
    }
}
