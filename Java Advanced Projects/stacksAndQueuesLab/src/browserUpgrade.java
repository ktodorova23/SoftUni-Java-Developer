import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class browserUpgrade {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Deque<String> backStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();

        while (!line.equals("Home")) {
            if (!line.equals("back") && !line.equals("forward")) {
                backStack.push(line);
                if (forwardStack.size() > 0) {
                    forwardStack.clear();
                }
                System.out.println(line);
            } else if (line.equals("back")) {
                if (backStack.size() > 1) {
                    String forwardURL = backStack.pop();
                    forwardStack.push(forwardURL);
                    System.out.println(backStack.peek());;
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                if (forwardStack.size() > 0) {
                    String forwardURL = forwardStack.pop();
                    backStack.push(forwardURL);
                    System.out.println(forwardURL);
                } else {
                    System.out.println("no next URLs");
                }
            }

            line = console.nextLine();
        }
    }
}
