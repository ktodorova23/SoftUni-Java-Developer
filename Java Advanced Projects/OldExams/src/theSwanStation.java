import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class theSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::offer);

        Deque<Integer> inputNums = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(inputNums::offer);

        Deque<Integer> resultNums = new ArrayDeque<>();
        while (!numbers.isEmpty()) {
            int upper = numbers.peek();
            int lower = inputNums.peek();

            if (lower % upper == 0) {
                int upperErase = numbers.poll();
                int lowerErase = inputNums.poll();
                resultNums.offer(lowerErase);
            } else {
                int lowerErase = inputNums.poll();
                inputNums.offer(lowerErase + 1);
            }
        }

        int size = resultNums.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print(resultNums.poll() + ", ");
            } else {
                System.out.println(resultNums.poll());
            }
        }
    }
}
