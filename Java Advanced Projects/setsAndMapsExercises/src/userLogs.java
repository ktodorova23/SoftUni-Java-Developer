import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class userLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> ipCountsByUsername = new TreeMap<>();

        while (!line.equals("end")) {
            String[] tokens = line.split("\\s+");
            String[] ipData = tokens[0].split("=");
            String[] usernameData = tokens[2].split("=");

            String IP = ipData[1];
            String username = usernameData[1];

            ipCountsByUsername.putIfAbsent(username, new LinkedHashMap<>());
            ipCountsByUsername.get(username).putIfAbsent(IP, 0);
            ipCountsByUsername.get(username).put(IP, ipCountsByUsername.get(username).get(IP) + 1);

            line = console.nextLine();
        }

        ipCountsByUsername.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + ": ");
            final int[] count = {e.getValue().size()};
            e.getValue().entrySet().stream().forEach(el -> {
                count[0]--;
                System.out.print(el.getKey() + " => " + el.getValue());
                if (count[0] > 0) {
                    System.out.print(", ");
                } else {
                    System.out.println(".");
                }
            });
        });
    }
}
