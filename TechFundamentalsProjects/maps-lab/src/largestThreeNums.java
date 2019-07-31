import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class largestThreeNums {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> row = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> sorted = row.stream().sorted((e1, e2) -> e2.compareTo(e1)).collect(Collectors.toList());

        if (sorted.size()< 3) {
            for (int i = 0; i < sorted.size(); i++) {
                System.out.print(sorted.get(i) + " ");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(sorted.get(i) + " ");
            }
        }

    }
}
