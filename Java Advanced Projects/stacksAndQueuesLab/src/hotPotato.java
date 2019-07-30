import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class hotPotato {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Deque<String> names = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+")).forEach(names::offer);
        int count = Integer.parseInt(console.nextLine());

        while (names.size() > 1) {
            for (int i = 0; i < count - 1; i++) {
                String name = names.poll();
                names.offer(name);

            }
            String removedName = names.poll();
            System.out.println("Removed " + removedName);
        }

        String lastName = names.poll();
        System.out.println("Last is " + lastName);
    }
}
