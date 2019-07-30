import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class crossfire {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] dimensions = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int number = 1;

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(number);
                number++;

            }
        }

        String line = console.nextLine();

        while (!line.equals("Nuke it from orbit")) {
            int[] command = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int row = command[0];
            int col = command[1];
            int power = command[2];

            destroyColumns(matrix, row, col, power);
            destroyRows(matrix, row, col, power);
            removeBlankRows(matrix);


            line = console.nextLine();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void removeBlankRows(ArrayList<ArrayList<Integer>> matrix) {
        matrix.removeIf(line -> line.isEmpty());
    }

    private static void destroyRows(ArrayList<ArrayList<Integer>> matrix, int row, int col, int power) {
        for (int r = col - power; r < col + power; r++) {
            if (isValidDimension(matrix, row, r)) {
                matrix.get(row).remove(r);
                r--;
            }
        }
    }

    private static void destroyColumns(ArrayList<ArrayList<Integer>> matrix, int row, int col, int power) {
        for (int r = row - power; r <= row + power; r++) {
            if (isValidDimension(matrix, r, col)) {
                matrix.get(r).remove(col);
            }
        }
    }

    private static boolean isValidDimension(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}
