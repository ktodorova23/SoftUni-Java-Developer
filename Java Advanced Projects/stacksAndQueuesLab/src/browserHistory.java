import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class browserHistory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Deque<String> browserStack = new ArrayDeque<>();

        while (!line.equals("Home")) {
            if (!line.equals("back")) {
                browserStack.push(line);
                System.out.println(browserStack.peek());
            } else {
                if (browserStack.size() > 1) {
                    browserStack.pop();
                    System.out.println(browserStack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }

            line = console.nextLine();
        }
    }
}
