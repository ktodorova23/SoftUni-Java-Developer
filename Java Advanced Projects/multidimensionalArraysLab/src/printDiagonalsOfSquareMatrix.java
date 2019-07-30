import java.util.Arrays;
        import java.util.Scanner;

public class printDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int matrixData = Integer.parseInt(console.nextLine());

        int[][] matrix = new int[matrixData][matrixData];

        for (int i = 0; i < matrixData; i++) {
            int[] data = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = data;
        }

        for (int i = 0; i < matrixData; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < matrixData; i++) {
            System.out.print(matrix[matrixData - i - 1][i] + " ");
        }
    }
}
