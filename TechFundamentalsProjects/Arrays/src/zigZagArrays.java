import java.util.Scanner;

public class zigZagArrays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rows = Integer.parseInt(console.nextLine());

        int[] firstArray = new int[rows];
        int[] secondArray = new int[rows];

        for (int i = 0; i < rows; i++) {
            String [] pair = console.nextLine().split(" ");

            int num1 = Integer.parseInt(pair[0]);
            int num2 = Integer.parseInt(pair[1]);

            if (i % 2 == 0) {
                firstArray[i] = num1;
                secondArray[i] = num2;
            } else {
                firstArray[i] = num2;
                secondArray[i]= num1;
            }

        }

        for (int i = 0; i < firstArray.length; i++) {
            System.out.print(firstArray[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < secondArray.length; i++) {
            System.out.print(secondArray[i] + " ");
        }
    }
}
