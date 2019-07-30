import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class mathPotato {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Deque<String> namesQueue = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+")).forEach(namesQueue::offer);
        int count = Integer.parseInt(console.nextLine());

        int round = 1;

        while (namesQueue.size() > 1) {
            for (int i = 0; i < count - 1; i++) {
                String name = namesQueue.poll();
                namesQueue.offer(name);
            }

            if (isPrime(round)) {
                System.out.println("Prime " + namesQueue.peek());
            } else {
                String name = namesQueue.poll();
                System.out.println("Removed " + name);
            }
            round++;
        }

        System.out.println("Last is " + namesQueue.peek());
    }

    private static boolean isPrime(int round) {
        if (round == 1) {
            return false;
        }

        for (int i = 2; i < round; i++) {
            if (round % i == 0) {
                return false;
            }
        }
        return true;
    }
}
