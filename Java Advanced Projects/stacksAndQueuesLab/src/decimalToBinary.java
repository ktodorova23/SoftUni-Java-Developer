import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class decimalToBinary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
        }
        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}
