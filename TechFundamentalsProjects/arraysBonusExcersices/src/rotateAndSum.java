import java.util.Arrays;
import java.util.Scanner;

public class rotateAndSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputArray = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rotationsCount = Integer.parseInt(console.nextLine());

        int[] summedNumbers = new int[inputArray.length];

        for (int i = 0; i < rotationsCount; i++) {
            int lastDigit = inputArray[inputArray.length - 1];
            for (int j = inputArray.length - 1; j >= 1; j--) {
                inputArray[j] = inputArray[j - 1];
            }
            inputArray[0] = lastDigit;

            for (int j = 0; j < summedNumbers.length; j++) {
                summedNumbers[j] += inputArray[j];
            }
        }

        for (int i = 0; i < summedNumbers.length; i++) {
            System.out.print(summedNumbers[i] + " ");
        }
        System.out.println();
    }
}
