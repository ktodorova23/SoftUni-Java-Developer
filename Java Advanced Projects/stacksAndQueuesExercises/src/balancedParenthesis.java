import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class balancedParenthesis {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String parenthesis = console.nextLine();

        Deque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < parenthesis.length(); i++) {
            char symbol = parenthesis.charAt(i);

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                stack.push(symbol);
            } else {
                if (!stack.isEmpty()) {
                    char peek = stack.peek();
                    if (!((symbol == ')' && peek == '(') || (symbol == ']' && peek == '[') || (symbol == '}' && peek == '{')) || stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
