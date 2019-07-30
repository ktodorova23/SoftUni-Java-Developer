import java.util.Scanner;

public class recursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        memory = new long[number + 1];

        System.out.println(calculateFibonacci(number));
    }

    private static long calculateFibonacci(int number) {
        if (number < 2) {
            return 1;
        }

        if (memory[number] != 0) {
            return memory[number];
        }

        return memory[number] = calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
    }
}
