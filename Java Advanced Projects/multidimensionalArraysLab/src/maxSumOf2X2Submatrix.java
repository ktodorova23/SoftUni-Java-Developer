import java.util.Arrays;
import java.util.Scanner;

public class maxSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] data = console.nextLine().split(", ");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] rowData = Arrays.stream(console.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = rowData;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1, maxCol = -1;
        for (int i = 0; i < matrix.length - 1; i++) {
            int currentSum = 0;
            for (int j = 0; j < matrix[0].length - 1; j++) {
                currentSum = getSum(matrix, i, j);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println(String.format("%d %d%n%d %d%n%d", matrix[maxRow][maxCol], matrix[maxRow][maxCol + 1],
                                        matrix[maxRow + 1][maxCol], matrix[maxRow + 1][maxCol + 1], maxSum));
    }

    private static int getSum(int[][] matrix, int row, int col) {
        int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
        return sum;
    }
}
