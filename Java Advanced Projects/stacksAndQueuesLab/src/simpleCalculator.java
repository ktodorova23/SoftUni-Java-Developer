import java.util.*;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, input);

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            char operator = stack.pop().charAt(0);
            int secondNumber = Integer.parseInt(stack.pop());

            int result = 0;

            if (operator == '-') {
                result = firstNumber - secondNumber;
            } else {
                result = firstNumber + secondNumber;
            }
            stack.push(String.valueOf(result));
        }

        System.out.println(stack.peek());
    }
}
