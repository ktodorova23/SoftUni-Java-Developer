import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class bombNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> sequence = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bombIndications = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bomb = bombIndications[0];
        int power = bombIndications[1];

        while(sequence.contains(bomb)) {
            int index = sequence.indexOf(bomb);
            int begin = Math.max(0, (index - power));

            for (int i = begin; i < index; i++) {
                sequence.remove(begin);
            }

            index = sequence.indexOf(bomb);

            int end = Math.min((index + power), (sequence.size() - 1));

            for (int i = index; i <= end; i++) {
                sequence.remove(index);
            }
        }

        int sum = 0;

        for (int i = 0; i < sequence.size(); i++) {
            sum += sequence.get(i);
        }

        System.out.println(sum);
    }
}
