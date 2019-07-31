import java.util.*;

public class companyUsers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        Map<String, List<String>> users = new LinkedHashMap<>();

        while (!line.equals("End")) {
            String[] input = line.split(" -> ");

            String companyName = input[0];
            String id = input[1];

            users.putIfAbsent(companyName, new ArrayList<>());
            if (!users.get(companyName).contains(id)) {
                users.get(companyName).add(id);
            }

            line = console.nextLine();
        }

        users.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).forEach(key -> {
            System.out.println(key.getKey());
            for (String entry:key.getValue()) {
                System.out.print("-- ");
                System.out.println(entry);
            }});
    }
}
