import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class changeListSecondTry {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(console.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = console.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String cmd = tokens[0];

            switch (cmd) {
                case "Delete":
                    int element = Integer.parseInt(tokens[1]);
                    while (elements.contains(element)) {
                        elements.remove(Integer.valueOf(element));
                    }
                    break;
                case "Insert":
                    int elementToInsert = Integer.parseInt(tokens[1]);
                    int position = Integer.parseInt(tokens[2]);

                    if (position <= elements.size() - 1) {
                        elements.add(position, elementToInsert);
                    } else {
                        elements.add(elementToInsert);
                    }
                    break;
            }

            input = console.nextLine();
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
