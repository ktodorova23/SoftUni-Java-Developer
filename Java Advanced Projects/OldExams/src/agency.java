import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class agency {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> idStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(idStack::push);

        Deque<String> agentsQueue = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(agentsQueue::offer);

        String line;
        while (!"stop".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "add-ID":
                    String id = tokens[1];
                    idStack.push(id);
                    break;
                case "add-agent":
                    String agent = tokens[1];
                    agentsQueue.offer(agent);
                    break;
                case "remove-ID":
                    String idToRemove = idStack.pop();
                    System.out.println(String.format("%s has been removed.", idToRemove));
                    break;
                case "remove-agent":
                    String agentToRemove = agentsQueue.pollLast();
                    System.out.println(String.format("%s has left the queue.", agentToRemove));
                    break;
                case "sort-ID":
                    idStack = idStack.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }
        }

        while (!(idStack.isEmpty() || agentsQueue.isEmpty())) {
            String agent = agentsQueue.poll();
            String id = idStack.pop();
            System.out.println(String.format("%s takes ID number: %s", agent, id));
        }

        if (idStack.size() > 0) {
            System.out.println("No more agents left.");
            while (!idStack.isEmpty()) {
                String id = idStack.pop();
                System.out.println(String.format("ID number: %s", id));
            }
        }

        if (agentsQueue.size() > 0) {
            while (!agentsQueue.isEmpty())  {
                String agent = agentsQueue.poll();
                System.out.println(String.format("%s does not have an ID.", agent));
            }
        }
    }
}
