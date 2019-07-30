import java.util.Arrays;
import java.util.Scanner;

public class maximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] data = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = data[0];
        int cols = data[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowData;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1, maxCol = -1;

        for (int row = 0; row < matrix.length - 2; row++) {
            int currentSum = 0;
            for (int col = 0; col < matrix[row].length - 2; col++) {
                currentSum = calculateSum(matrix, row, col);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        System.out.println(String.format("%d %d %d%n%d %d %d%n%d %d %d",
                matrix[maxRow][maxCol], matrix[maxRow][maxCol + 1], matrix[maxRow][maxCol + 2],
                matrix[maxRow + 1][maxCol], matrix[maxRow + 1][maxCol + 1], matrix[maxRow + 1][maxCol + 2],
                matrix[maxRow + 2][maxCol], matrix[maxRow + 2][maxCol + 1], matrix[maxRow + 2][maxCol + 2]));
    }

    private static int calculateSum(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
    }
}
