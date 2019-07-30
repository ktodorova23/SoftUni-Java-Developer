import java.util.*;

public class basicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputs = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numbersToAdd = inputs[0];
        int numbersToPoll = inputs[1];
        int numberToFind = inputs[2];

        Deque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(console.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(numbersToAdd)
                .forEach(queue::offer);

        for (int i = 0; i < numbersToPoll; i++) {
            queue.poll();
        }

        if (queue.contains(numberToFind)) {
            System.out.println("true");
        } else {
            if (!queue.isEmpty()) {
                int min = Collections.min(queue);
                System.out.println(min);
            } else {
                System.out.println(0);
            }
        }


    }
}
