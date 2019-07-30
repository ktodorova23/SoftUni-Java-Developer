import java.util.Scanner;

public class positionsOf {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] data = console.nextLine().split("\\s+");

        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] numbers = console.nextLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }

        int number = Integer.parseInt(console.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == number) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }

    }
}
