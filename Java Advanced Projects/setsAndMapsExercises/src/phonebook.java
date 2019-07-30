import java.util.HashMap;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        while (!line.equals("search")) {
            String[] entry = line.split("-");

            phonebook.putIfAbsent(entry[0], entry[1]);
            phonebook.put(entry[0], entry[1]);

            line = console.nextLine();
        }

        line = console.nextLine();

        while (!line.equals("stop")) {
            if (phonebook.containsKey(line)) {
                System.out.println(String.format("%s -> %s", line, phonebook.get(line)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", line));
            }

            line = console.nextLine();
        }
    }
}
