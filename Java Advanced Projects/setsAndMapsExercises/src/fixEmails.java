import java.util.LinkedHashMap;
import java.util.Scanner;

public class fixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        LinkedHashMap<String, String> emailsByNames = new LinkedHashMap<>();

        int count = 0;
        String previousName = "";

        while (!line.equals("stop")) {
            count++;
            if (count % 2 != 0) {
                emailsByNames.putIfAbsent(line, "");
                previousName = line;
            } else {
                if (line.contains("uk") || line.contains("us") || line.contains("com")) {
                    if (emailsByNames.containsKey(previousName)) {
                        emailsByNames.remove(previousName);
                    }
                } else {
                    emailsByNames.put(previousName, line);
                }
            }

            line = console.nextLine();
        }

        emailsByNames.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
