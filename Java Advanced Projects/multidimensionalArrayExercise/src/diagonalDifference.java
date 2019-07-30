import java.util.Arrays;
import java.util.Scanner;

public class diagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowData;
        }

        int firstDiagonal = calculateFirstDiagonal(matrix);
        int secondDiagonal = calculateSecondDiagonal(matrix);

        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }

    private static int calculateSecondDiagonal(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    private static int calculateFirstDiagonal(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }
}
