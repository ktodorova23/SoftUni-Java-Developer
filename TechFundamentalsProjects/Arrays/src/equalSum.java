import java.util.Scanner;

public class equalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int[] numbers = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }

        boolean hasEquality = false;

        for (int i = 0; i < numbers.length; i++) {
            int sum1 = 0;
            for (int j = i - 1; j >= 0; j--) {
                sum1 += numbers[j];
            }
            int sum2 = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                sum2 += numbers[j];
            }

            if (sum1 == sum2) {
                System.out.println(i);
                hasEquality = true;
                break;
            }
        }

        if (!hasEquality) {
            System.out.println("no");
        }
    }
}
