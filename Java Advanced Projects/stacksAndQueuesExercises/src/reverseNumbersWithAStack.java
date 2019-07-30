import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class reverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Deque<Integer> stackOfNums = new ArrayDeque<>();

        Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackOfNums::push);

        while (!stackOfNums.isEmpty()) {
            int n = stackOfNums.pop();
            System.out.print(n + " ");
        }
    }
}
