import java.util.Scanner;

public class equalArrays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] firstInput = console.nextLine().split(" ");
        String[] secondInput = console.nextLine().split(" ");

        int[] firstArray = new int[firstInput.length];
        int[] secondArray = new int[secondInput.length];

        for (int i = 0; i < firstInput.length; i++) {
            firstArray[i] = Integer.parseInt(firstInput[i]);
            secondArray[i] = Integer.parseInt(secondInput[i]);
        }

        int sum = 0;
        int maxLength = Math.max(firstArray.length, secondArray.length);

        for (int i = 0; i < maxLength; i++) {
            sum += firstArray[i];
            if (firstArray[i] != secondArray[i]) {
                System.out.println(String.format("Arrays are not identical. Found difference at %d index.", i));
                sum = 0;
                break;
            }
        }
        if (sum != 0) {
        System.out.println(String.format("Arrays are identical. Sum: %d", sum));
    }
    }
}
