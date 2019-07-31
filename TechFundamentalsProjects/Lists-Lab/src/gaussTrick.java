import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class gaussTrick {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> input = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int size = input.size();

        for (int i = 0; i < size / 2; i++) {
            input.set(i, input.get(i) + input.get(input.size() - 1));
            input.remove(input.size() - 1);
        }


        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
    }
}
