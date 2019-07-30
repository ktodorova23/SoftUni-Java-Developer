import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> lefties = new ArrayDeque<>();
        Deque<Integer> righties = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lefties::push);

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(righties::offer);

        List<Integer> pairs = new ArrayList<>();

        while (!lefties.isEmpty() && !righties.isEmpty()) {
            int currentLeft = lefties.pop();
            int currentRight = righties.poll();

            if (currentLeft > currentRight) {
                pairs.add(currentLeft + currentRight);
            } else if (currentLeft == currentRight) {
                currentLeft++;
                lefties.push(currentLeft);
            } else {
                righties.addFirst(currentRight);
            }
        }

        System.out.println(Collections.max(pairs));
        System.out.println(pairs.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
