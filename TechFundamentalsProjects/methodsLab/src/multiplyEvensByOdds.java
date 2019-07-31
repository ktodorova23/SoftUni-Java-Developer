import java.util.Arrays;
        import java.util.Scanner;

public class multiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] input = Arrays.stream(console.nextLine().replaceAll("-", "").split("")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                evenSum += input[i];
            } else {
                oddSum += input[i];
            }
        }

        int result = evenSum * oddSum;
        System.out.println(result);
    }
}
