import java.util.*;

public class basicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputs = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numbersToPush = inputs[0];
        int numbersToPop = inputs[1];
        int numberToFind = inputs[2];

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(numbersToPush)
                .forEach(stack::push);

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.contains(numberToFind)) {
            System.out.println("true");
        } else {
            if (!stack.isEmpty()) {
                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }
    }
}
