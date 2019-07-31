import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(console.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String commands = console.nextLine();

        while (!commands.equals("end")) {
            String[] cmd = commands.split(" ");

            switch (cmd[0]) {
                case ("Add"):
                    int numberToAdd = Integer.parseInt(cmd[1]);
                    inputList.add(numberToAdd);
                break;
                case ("Remove"):
                    int numberToRemove = Integer.parseInt(cmd[1]);
                    inputList.remove(Integer.valueOf(numberToRemove));
                    break;
                case ("RemoveAt"):
                    int indexToRemove = Integer.parseInt(cmd[1]);
                    inputList.remove(indexToRemove);
                    break;
                case ("Insert"):
                    int numberToInsert = Integer.parseInt(cmd[1]);
                    int indexToInsertOn = Integer.parseInt(cmd[2]);
                    inputList.add(indexToInsertOn, numberToInsert);
                    break;
            }

            commands = console.nextLine();
        }

        for (Integer aInputList : inputList) {
            System.out.print(aInputList + " ");
        }
    }
}
