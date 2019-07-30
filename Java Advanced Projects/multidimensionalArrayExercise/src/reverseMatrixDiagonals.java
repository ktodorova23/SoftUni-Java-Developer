import java.util.Arrays;
import java.util.Scanner;

public class reverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] dimensions = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int [][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {
            int c = col;
            int r = row;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }
}
