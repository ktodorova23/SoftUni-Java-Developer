import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class changeListCopyPaste {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        String line = console.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];

            if (command.equals("Delete")) {
                int element = Integer.parseInt(tokens[1]);

                while (numbers.contains(element)) {
                    numbers.remove(Integer.valueOf(element));
                }
            } else {
                int element = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);

                if (index <= numbers.size() - 1) {
                    numbers.add(index, element);
                }

            }

            line = console.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
