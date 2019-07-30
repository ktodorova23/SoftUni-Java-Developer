import java.util.*;

public class maximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        Deque<Integer> stackOfNumbers = new ArrayDeque<>();

        while (rows-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "1":
                    int numberToPush = Integer.parseInt(tokens[1]);
                    stackOfNumbers.push(numberToPush);
                    break;
                case "2":
                    stackOfNumbers.pop();
                    break;
                case "3":
                    int maxValue = Collections.max(stackOfNumbers);
                    System.out.println(maxValue);
                    break;
            }
        }
    }
}
