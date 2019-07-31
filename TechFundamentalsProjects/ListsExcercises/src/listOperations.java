import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = console.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    inputList.add(number);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int positionToInsertTo = Integer.parseInt(tokens[2]);
                    if (positionToInsertTo < 0 || positionToInsertTo >= inputList.size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                    inputList.add(positionToInsertTo, numberToInsert);
                    break;
                case "Remove":
                    int removeAtIndex = Integer.parseInt(tokens[1]);
                    if (removeAtIndex < 0 || removeAtIndex >= inputList.size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                    inputList.remove(removeAtIndex);
                    break;
                case "Shift":
                    if (tokens[1].equals("left")) {
                        int count = Integer.parseInt(tokens[2]);

                        while (count > 0) {
                            int firstNum = inputList.get(0);
                            for (int i = 0; i < inputList.size() - 1; i++) {
                                inputList.set(i, inputList.get(i + 1));
                            }
                            inputList.set(inputList.size() - 1, firstNum);
                            count--;
                        }
                    } else {
                        int countRight = Integer.parseInt(tokens[2]);
                        while (countRight > 0) {
                            int lastNum = inputList.get(inputList.size() - 1);
                            for (int i = inputList.size() - 1; i > 0; i--) {
                                inputList.set(i, inputList.get(i - 1));
                            }
                            inputList.set(0, lastNum);
                            countRight--;
                        }


                    }
                    break;
            }

            line = console.nextLine();
        }

        for (Integer anInputList : inputList) {
            System.out.print(anInputList + " ");
        }
    }
}
