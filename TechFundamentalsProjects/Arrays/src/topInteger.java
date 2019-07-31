import java.util.Scanner;

public class topInteger {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");

        int[] startingNums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            startingNums[i] = Integer.parseInt(input[i]);
        }

//        boolean isTopInt = true;

        for (int i = 0; i < startingNums.length - 1; i++) {
//            int number = startingNums[i];
            for (int j = i+1; j < startingNums.length; j++) {
//                int secondNum = startingNums[j];
                if (startingNums[i] <= startingNums[j]) {
                    break;
                } else if (j == startingNums.length-1) {
                    System.out.print(startingNums[i] + " ");
                }
            }
        }
        System.out.println(startingNums[startingNums.length - 1]);
    }
}
