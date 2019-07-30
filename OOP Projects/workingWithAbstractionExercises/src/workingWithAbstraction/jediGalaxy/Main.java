package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = splitCommand(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int filler = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = filler++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] ivoCoordinates = splitCommand(command);
            int[] evilCoordinates = splitCommand(scanner.nextLine());
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            moveEvil(matrix, evilRow, evilCol);

            int ivoRow = ivoCoordinates[0];
            int ivoCol = ivoCoordinates[1];

            sum = collectStars(matrix, sum, ivoRow, ivoCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long collectStars(int[][] matrix, long sum, int ivoRow, int ivoCol) {
        while (ivoRow >= 0 && ivoCol < matrix[1].length) {
            if (ivoRow < matrix.length && ivoCol >= 0 && ivoCol < matrix[0].length) {
                sum += matrix[ivoRow][ivoCol];
            }

            ivoCol++;
            ivoRow--;
        }
        return sum;
    }

    private static void moveEvil(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static int[] splitCommand(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
