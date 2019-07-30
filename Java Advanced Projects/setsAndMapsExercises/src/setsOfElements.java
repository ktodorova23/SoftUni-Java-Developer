import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class setsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] data = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int first = data[0];
        int second = data[1];

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        while (first-- > 0) {
            int number = Integer.parseInt(console.nextLine());
            firstSet.add(number);
        }

        while (second-- > 0) {
            int number = Integer.parseInt(console.nextLine());
            secondSet.add(number);
        }

        for (Integer firstNumber : firstSet) {
            for (Integer secondNum : secondSet) {
                if (firstNumber == secondNum) {
                    System.out.print(firstNumber + " ");
                }
            }
        }
    }
}
