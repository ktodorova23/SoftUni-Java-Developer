import java.util.Arrays;
import java.util.Scanner;

public class wrongMeasurements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        int[][] originalMatrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] rowData = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            originalMatrix[i] = rowData;
        }

        String[] coordinates = console.nextLine().split("\\s+");
        int numberRow = Integer.parseInt(coordinates[0]);
        int numberCol = Integer.parseInt(coordinates[1]);

        int numberToFind = originalMatrix[numberRow][numberCol];

        int[][] matrix = new int[rows][originalMatrix[0].length];

        for (int row = 0; row < rows; row++) {
            int newNumber = 0;
            for (int col = 0; col < originalMatrix[0].length; col++) {
                if (originalMatrix[row][col] == numberToFind) {
                    newNumber = calculateNewNumber(originalMatrix, row, col, numberToFind);
                    matrix[row][col] = newNumber;
                } else {
                    matrix[row][col] = originalMatrix[row][col];
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.print(matrix[row][i] + " ");
            }
            System.out.println();
        }
    }

    private static int calculateNewNumber(int[][] originalMatrix, int row, int col, int numberToFind) {
        int number = 0;

        if (col - 1 >= 0 && originalMatrix[row][col - 1] != numberToFind) {
            number = originalMatrix[row][col - 1];
        }

        if (row - 1 >= 0 && originalMatrix[row - 1][col] != numberToFind) {
            if (number != 0) {
                number += originalMatrix[row - 1][col];
            } else {
                number = originalMatrix[row - 1][col];
            }
        }

        if (col + 1 < originalMatrix[0].length && originalMatrix[row][col + 1] != numberToFind) {
            if (number != 0) {
                number += originalMatrix[row][col + 1];
            } else {
                number = originalMatrix[row][col + 1];
            }
        }

        if (row + 1 < originalMatrix.length && originalMatrix[row + 1][col] != numberToFind) {
            if (number != 0) {
                number += originalMatrix[row + 1][col];
            } else  {
                number = originalMatrix[row + 1][col];
            }
        }

        return number;
    }
}
