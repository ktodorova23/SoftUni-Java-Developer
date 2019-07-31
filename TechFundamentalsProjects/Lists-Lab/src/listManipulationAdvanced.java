import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulationAdvanced {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String commands = console.nextLine();

        while (!commands.equals("end")) {
            String[] tokens = commands.split(" ");

            switch (tokens[0]) {
                case "Contains":
                    int containedNumber = Integer.parseInt(tokens[1]);
                    if (inputList.contains(containedNumber)) {
                        System.out.print("Yes");
                    } else {
                        System.out.print("No such number");
                    }
                    break;
                case "Print":
                    if (tokens[1].equals("even")) {
                        inputList.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.print(e + " "));
                    } else {
                        inputList.stream().filter(e -> e % 2 != 0).forEach(e -> System.out.print(e + " "));
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer anInputList : inputList) {
                        sum += anInputList;
                    }
                    System.out.print(sum);
                    break;
                case "Filter":
                    int number = Integer.parseInt(tokens[2]);

                    switch (tokens[1]) {
                        case "<":
                            inputList.stream().filter(e -> e < number).forEach(e -> System.out.print(e + " "));
                            break;
                        case "<=":
                            inputList.stream().filter(e -> e <= number).forEach(e -> System.out.print(e + " "));
                            break;
                        case ">":
                            inputList.stream().filter(e -> e > number).forEach(e -> System.out.print(e + " "));
                            break;
                        case ">=":
                            inputList.stream().filter(e -> e >= number).forEach(e -> System.out.print(e + " "));
                            break;
                    }
                    break;
            }

            System.out.println();
            commands = console.nextLine();
        }
    }
}
