import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Map<String, Integer> resourceCount = new LinkedHashMap<>();

        int count = 1;
        String lastResourceCmd = "";

        while (!line.equals("stop")) {
            if (count % 2 == 1) {
                resourceCount.putIfAbsent(line, 0);
                lastResourceCmd = line;
                } else {
                int number = Integer.parseInt(line);
                resourceCount.put(lastResourceCmd, resourceCount.get(lastResourceCmd) + number);
            }
            count++;
            line = console.nextLine();
        }

        for (Map.Entry<String, Integer> entry:resourceCount.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }
}
