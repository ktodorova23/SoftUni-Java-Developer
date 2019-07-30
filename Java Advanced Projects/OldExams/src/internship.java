import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class internship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        Deque<String> problemsStack = new ArrayDeque<>();

        Deque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            String input = reader.readLine();
            problemsStack.push(input);
        }

        for (int i = 0; i < candidatesCount; i++) {
            String input = reader.readLine();
            if (input.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                candidatesQueue.offer(input);
            }
        }

        while (true) {
            if (candidatesQueue.size() == 1 || problemsStack.isEmpty()) {
                break;
            }

            String candidate = candidatesQueue.poll();
            String problem = problemsStack.pop();
            if (ASCIIsum(candidate) > ASCIIsum(problem)) {
                candidatesQueue.offer(candidate);
                System.out.println(String.format("%s solved %s.", candidate, problem));
            } else {
                problemsStack.offer(problem);
                System.out.println(String.format("%s failed %s.", candidate, problem));
            }
        }

        if (candidatesQueue.size() == 1) {
            System.out.println(String.format("%s gets the job!", candidatesQueue.poll()));
            return;
        }

        if (problemsStack.isEmpty()) {
            System.out.println(String.join(", ", candidatesQueue));
        }


    }

    private static int ASCIIsum(String text) {
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            sum += text.charAt(i);
        }

        return sum;
    }
}
