import java.util.Arrays;
import java.util.Scanner;

public class matrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = data[0];
        int cols = data[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            matrix[row] = rowData;
        }

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            if (checkValidity(line, rows, cols)) {
                String[] info = line.split("\\s+");
                int firstRow = Integer.parseInt(info[1]);
                int firstCol = Integer.parseInt(info[2]);
                int secondRow = Integer.parseInt(info[3]);
                int secondCol = Integer.parseInt(info[4]);
                
                String firstElement = matrix[firstRow][firstCol];
                String secondElement = matrix[secondRow][secondCol];
                
                matrix[firstRow][firstCol] = secondElement;
                matrix[secondRow][secondCol] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            line = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkValidity(String line, int rows, int cols) {
        String[] data = line.split("\\s+");
        
        if (!line.contains("swap")) {
            return false;
        }

        if (data.length != 5) {
            return false;
        } else {
            int firstRow = Integer.parseInt(data[1]);
            int firstCol = Integer.parseInt(data[2]);
            int secondRow = Integer.parseInt(data[3]);
            int secondCol = Integer.parseInt(data[4]);
            
            if (firstRow < 0 || firstRow > rows - 1 || 
                    secondRow < 0 || secondRow > rows - 1 ||
                    firstCol < 0 || firstCol > cols - 1 ||
                    secondCol < 0 || secondCol > cols - 1) {
                return false;
            }
        }

        return true;
    }
}
