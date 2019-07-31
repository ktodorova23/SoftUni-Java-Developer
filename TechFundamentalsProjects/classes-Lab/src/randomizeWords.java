import java.util.*;
import java.util.stream.Collectors;

public class randomizeWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> input = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());

        Random rnd = new Random();

        for (int i = 0; i < input.size(); i++) {
            int randomNum = rnd.nextInt(input.size());
            Collections.swap(input, (input.size() - 1), randomNum);
        }

        input.forEach(System.out::println);
    }
}
