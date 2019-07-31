import java.util.Scanner;

public class arrayManipulator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] array = console.nextLine().split(" ");

        int[] numberArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            numberArray[i] = Integer.parseInt(array[i]);
        }

        String input = console.nextLine();

        while (!input.equals("end")) {
            if (input.contains("exchange")) {
                System.out.println(exchangeCmd(input, numberArray));
            }
            input = console.nextLine();
        }
    }

    public static String exchangeCmd(String cmd, int[] numberArray) {
        String[] command = cmd.split(" ");

        int positionSwitch = Integer.parseInt(command[1]);

        if (positionSwitch < 0 || positionSwitch >= numberArray.length) {
            return "Invalid index";
        }

//        int[] newArray = new int[];
        String newArray = "";

        for (int i = positionSwitch + 1; i < numberArray.length; i++) {
            newArray += numberArray[i] + " ";
        }

        for (int i = 0; i <= positionSwitch; i++) {
            newArray += numberArray[i] + " ";
        }

        return "[ " + newArray + "]";
    }

    public static int findMaxEvenOrOdd(String cmd, int[] numberArray) {
        int maxEven = Integer.MIN_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int i = 0; i < numberArray.length - 1; i++) {
            if (i % 2 == 0) {
                if(numberArray[i] > numberArray[i + 1]) {
                    maxEven = numberArray[i];
                }
                if (numberArray[i] < numberArray[i + 1]) {
                    minEven = numberArray[i];
                }
            } else {
                if(numberArray[i] > numberArray[i + 1]) {
                    maxOdd = numberArray[i];
                }
                if (numberArray[i] < numberArray[i + 1]) {
                    minOdd = numberArray[i];
                }
            }
        }
        if (cmd.equals("max odd")) {
            return maxOdd;
        } else if (cmd.equals("max even")) {
            return maxEven;
        } else if (cmd.equals("min odd")) {
            return minOdd;
        } else if (cmd.equals("min even")) {
            return minEven;
        }

    return minEven;
    }
}
