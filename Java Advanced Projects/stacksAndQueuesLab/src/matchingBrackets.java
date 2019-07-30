import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class matchingBrackets {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char currentSymbol = line.charAt(i);

            if (currentSymbol == '(') {
                stack.push(i);
            }

            if (currentSymbol == ')') {
                int beginningIndex = stack.pop();
                String bracket = line.substring(beginningIndex, i + 1);
                System.out.println(bracket);
            }
        }
    }
}
