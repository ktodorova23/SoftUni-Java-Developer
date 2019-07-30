import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class littleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stones = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stones::offer);

        String line;

        Deque<Integer> storage = new ArrayDeque<>();
        while (!"Revision".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            if (tokens[1].equals("acid")) {
                if (stones.size() > 0) {
                    int number = Integer.parseInt(tokens[2]);
                    while (number-- > 0) {
                        if (stones.isEmpty()) {
                            break;
                        } else  {
                            int currentStone = stones.poll() - 1;
                            if (currentStone == 0) {
                                storage.push(1);
                            } else {
                                stones.offer(currentStone);
                            }
                        }
                    }
                }
            } else {
                if (storage.size() > 0) {
                    int number = Integer.parseInt(tokens[2]);
                    storage.pop();
                    stones.offer(number);
                }
            }
        }

        while (!stones.isEmpty()) {
            System.out.print(stones.pop() + " ");
        }
        System.out.println();

        System.out.println(storage.size());
    }
}
