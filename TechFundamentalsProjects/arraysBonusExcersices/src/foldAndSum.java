import java.util.Arrays;
import java.util.Scanner;

public class foldAndSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputArray = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] smallerArray = new int[inputArray.length / 2];
        int[] summedNums = new int[smallerArray.length];

        for (int i = 0; i < smallerArray.length; i++) {
            for (int j = inputArray.length / 4 + i; j < inputArray.length / 4 + i + 1; j++) {
                smallerArray[i] = inputArray[j];
                summedNums[i] = inputArray[j];
            }
        }

        int[] secondArray = new int[smallerArray.length];

        int k = inputArray.length / 4;
        for (int i = 0; i < inputArray.length / 4; i++) {
            secondArray[i] = inputArray[k - i - 1];
            secondArray[k + i] = inputArray[inputArray.length - 1 - i];
        }

        for (int i = 0; i < summedNums.length; i++) {
            summedNums[i] += secondArray[i];
            System.out.print(summedNums[i] + " ");
        }
    }
}
