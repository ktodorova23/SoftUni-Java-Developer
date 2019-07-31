import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class removeNegativesAndReverse {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(console.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        inputList.removeIf(e -> e < 0);
        Collections.reverse(inputList);

        if (inputList.isEmpty()) {
            System.out.println("empty");
        } else {
            inputList.forEach(e -> System.out.print(e + " "));
        }


    }
}
