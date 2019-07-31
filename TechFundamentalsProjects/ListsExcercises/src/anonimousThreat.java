import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class anonimousThreat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> input = Arrays.stream(console.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        String line = console.nextLine();

        while (!line.equals("3:1")) {
            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];

            if (cmd.equals("merge")) {
                int start = Integer.parseInt(tokens[1]);
                int end = Integer.parseInt(tokens[2]);
                if (start < 0) {
                    start = 0;
                }
                if (end > input.size() - 1) {
                    end = input.size() - 1;
                }
                int count = end - start;
                while (count > 0) {
                    for (int i = start; i < input.size() - 1; i++) {
                        input.set(i, input.get(i) + input.get(i + 1));
                        input.remove(i + 1);
                        count--;
                    }
                }

                System.out.println();
            } else {
                int index = Integer.parseInt(tokens[1]);
                int parts = Integer.parseInt(tokens[2]);

                String element = input.get(Math.max(0,index));
                int splitSize = 0;

                if (element.length() % parts == 0) {
                    splitSize = element.length() / parts;
                    element.substring(0, splitSize);
                } else {
                    splitSize = element.length() / (parts - (element.length() % parts));

                    }
                }
            }

            line = console.nextLine();
        }
    }

