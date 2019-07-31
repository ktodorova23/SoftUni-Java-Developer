import java.util.*;
import java.util.stream.Collectors;

public class changeList {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<Integer> inputList = Arrays.stream(console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        String input = console.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split("\\s+");

            String cmd = command[0];

            if ("Delete".equals(cmd)) {
                int number = Integer.parseInt(command[1]);
                while (inputList.contains(number)) {
                    inputList.remove(Integer.valueOf(number));
                }

            } else {
                int numberToInsert = Integer.parseInt(command[1]);
                int indexToInsertOn = Integer.parseInt(command[2]);
                if (indexToInsertOn <= inputList.size() - 1) {
                    inputList.add(indexToInsertOn, numberToInsert);
                }

            }
            input = console.nextLine();
        }

        inputList.forEach(e -> System.out.print(e + " "));
    }
}
