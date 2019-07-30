import java.util.LinkedHashSet;
import java.util.Scanner;

public class uniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        LinkedHashSet<String> names = new LinkedHashSet<>();

        while (rows-- > 0) {
            String line = console.nextLine();

            names.add(line);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
