import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class softUniParking {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, String> onlineSystem = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine().split("\\s+");

            String cmd = input[0];
            String username = input[1];


            if (cmd.equals("register")) {
                String plateNumber = input[2];
                if (!onlineSystem.containsKey(username)) {
                    onlineSystem.put(username, plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", onlineSystem.get(username));
                }
            } else {
                if (!onlineSystem.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    onlineSystem.remove(username, onlineSystem.get(username));
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }

        onlineSystem.forEach((key, value) -> {
            System.out.print(key + " => ");
            System.out.println(value);
        });
    }
}
