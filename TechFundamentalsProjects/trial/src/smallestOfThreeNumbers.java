import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class smallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] array = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String cmd = console.nextLine();

        while (!cmd.equals("end")) {
            String[] tokens = cmd.split("\\s+");

            switch (cmd) {
                case "exchange":
                    int index = Integer.parseInt(tokens[1]);
                    List<Integer> temp = new ArrayList<>();
                    for (int i = index + 1; i < array.length; i++) {
                        temp.add(array[i]);
                    }
                    for (int i = 0; i <= index; i++) {
                        temp.add(array[i]);
                    }
                    for (int i = 0; i < array.length; i++) {
                        array[i] = temp.get(i);
                    }
                    temp.removeAll(temp);
                    break;
                case "max":
                    String secondPart = tokens[1];
                    if (secondPart.equals("even")) {
                        int maxEven = Integer.MIN_VALUE;
                        int position = 0;
                        boolean hasEvenNums = false;
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] % 2 == 0 && array[i] >= maxEven) {
                                hasEvenNums = true;
                                maxEven = array[i];
                                position = i;
                            }
                        }
                        if (!hasEvenNums) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(position);
                        }
                    } else {
                        int maxOdd = Integer.MIN_VALUE;
                        int position = 0;
                        boolean hasOddNums = false;
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] % 2 == 1 && array[i] >= maxOdd) {
                                hasOddNums = true;
                                maxOdd = array[i];
                                position = i;
                            }
                        }
                        if (!hasOddNums) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(position);
                        }
                    }
                    break;
                case "min":
                    String number = tokens[1];
                    if (number.equals("even")) {
                        int minEven = Integer.MAX_VALUE;
                        int position = 0;
                        boolean hasEvenNums = false;
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] % 2 == 0 && array[i] <= minEven) {
                                hasEvenNums = true;
                                minEven = array[i];
                                position = i;
                            }
                        }
                        if (!hasEvenNums) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(position);
                        }
                    } else {
                        int minOdd = Integer.MAX_VALUE;
                        int position = 0;
                        boolean hasOddNums = false;
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] % 2 == 1 && array[i] <= minOdd) {
                                hasOddNums = true;
                                minOdd = array[i];
                                position = i;
                            }
                        }
                        if (!hasOddNums) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(position);
                        }
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(tokens[1]);
                    if (count > array.length) {
                        System.out.println("Invalid count");
                    } else {
                    String type = tokens[2];
                    if (type.equals("even")) {
                        int tempCount = count;
                                for (int i = 0; i < array.length; i++) {
                                    if (array[i] % 2 == 0 && tempCount > 0) {
                                        if (i != array.length - 1) {
                                            System.out.print("[" + array[i] + ", ");
                                        } else {
                                            System.out.print(array[i] + "]");
                                        }
                                        tempCount--;
                                    }
                                }
                                System.out.println();
                        }else {
                        int tempCount = count;
                        for (int i = 0; i < array.length; i++) {
                            if (array[i] % 2 == 1 && tempCount > 0) {
                                if (i != array.length - 1) {
                                    System.out.print("[" + array[i] + ", ");
                                } else {
                                    System.out.print(array[i] + "]");
                                }
                                tempCount--;
                            }
                        }
                        System.out.println();
                    }
                    }
                    break;
                case "last":
                    break;
            }


            cmd = console.nextLine();
        }

    }
}
