import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class logsAggregator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeMap<String, List<String>> ipsByUser = new TreeMap<>();
        TreeMap<String, Integer> durationByUser = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");

            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            ipsByUser.putIfAbsent(user, new ArrayList<>());
            if (!ipsByUser.get(user).contains(ip)) {
                ipsByUser.get(user).add(ip);
            }
            durationByUser.putIfAbsent(user, 0);
            durationByUser.put(user, durationByUser.get(user) + duration);
        }

//        alex: 62 [10.10.17.33, 212.50.118.81]
        durationByUser.entrySet().stream()
                .forEach(u -> {
                    String user = u.getKey();
                    System.out.print(u.getKey() + ": " + u.getValue() + " [");
                    Collections.sort(ipsByUser.get(user));
                    int count = ipsByUser.get(user).size();
                    for (String IP : ipsByUser.get(user)) {
                        count--;
                        if (count > 0) {
                            System.out.print(IP + ", ");
                        } else {
                            System.out.println(IP + "]");
                        }
                    }
                });
    }
}
