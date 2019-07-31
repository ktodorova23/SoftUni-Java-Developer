import java.util.Scanner;

public class magicSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] strArray = console.nextLine().split(" ");
        int givenSum = Integer.parseInt(console.nextLine());

        int[] numbers = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            numbers[i] = Integer.parseInt(strArray[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                sum = numbers[i] + numbers[j];

                if (sum == givenSum) {
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }
    }
}
