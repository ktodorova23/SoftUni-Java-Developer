import java.util.Arrays;
import java.util.Scanner;

public class matrixOfPalindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] inputs = Arrays.stream(console.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int rows = inputs[0];
        int cols = inputs[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element = "" + (char)('a' + row) + (char)('a' + row + col) + (char)('a' + row);
                matrix[row][col] = element;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
