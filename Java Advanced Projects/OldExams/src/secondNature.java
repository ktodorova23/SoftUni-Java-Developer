import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class secondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> flowers = new ArrayDeque<>();
        Deque<Integer> buckets = new ArrayDeque<>();

        List<Integer> secondNatures = new ArrayList<>();

        Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(flowers::offer);

        Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(buckets::push);

        while (!flowers.isEmpty() && !buckets.isEmpty()) {
            int flowerPower = flowers.poll();
            int bucketPower = buckets.pop();

            if (flowerPower > bucketPower) {
                flowerPower -= bucketPower;
                flowers.addFirst(flowerPower);
            } else if (flowerPower == bucketPower) {
                secondNatures.add(flowerPower);
            } else {
                bucketPower -= flowerPower;
                if (!buckets.isEmpty()) {
                    int newPower = buckets.pop() + bucketPower;
                    buckets.push(newPower);
                } else {
                    buckets.push(bucketPower);
                }
            }
        }

        if (buckets.isEmpty()) {
            while (!flowers.isEmpty()) {
                System.out.print(flowers.poll() + " ");
            }
            System.out.println();
        }

        if (flowers.isEmpty()) {
            while (!buckets.isEmpty()) {
                System.out.print(buckets.pop() + " ");
            }
            System.out.println();
        }

        if (secondNatures.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println(secondNatures.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
