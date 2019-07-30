import java.util.Scanner;

public class fillTheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] data = console.nextLine().split(", ");

        int rows = Integer.parseInt(data[0]);
        String pattern = data[1];

        int[][] matrix = new int[rows][rows];

        switch (pattern) {
            case "A":
                matrix = fillMatrixPatternA(rows);
                break;
            case "B":
                matrix = fillMatrixPatternB(rows);
                break;
        }

        printMatrix(matrix);
    }

    private static int[][] fillMatrixPatternB(int rows) {
        int[][] matrix = new int[rows][rows];

        int firstNum = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = firstNum;
                    firstNum++;
                }
            } else {
                for (int j = rows - 1; j >= 0 ; j--) {
                    matrix[j][i] = firstNum;
                    firstNum++;
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixPatternA(int rows) {
        int[][] matrix = new int[rows][rows];

        int firstNum = 1;

        for (int i = 0; i < rows; i++) {
            matrix[i][0] = firstNum;
            firstNum++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < rows; j++) {
                matrix[i][j] = matrix[i][j - 1] + rows;
            }
        }

        return matrix;
    }
}
