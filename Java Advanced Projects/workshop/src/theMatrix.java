import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
@SuppressWarnings("Duplicates")
public class theMatrix {
    public static char filler;
    public static char charToReplace;
    public static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }

        filler = reader.readLine().charAt(0);

        int[] entryIndexes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int entryRow = entryIndexes[0];
        int entryCol = entryIndexes[1];

        charToReplace = matrix[entryRow][entryCol];

        paintMatrix(entryRow, entryCol);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void paintMatrix(int r, int c) {
        if (!isInMatrix(r, c) || matrix[r][c] != charToReplace) {
            return;
        }

        matrix[r][c] = filler;

        paintMatrix(r + 1, c);
        paintMatrix(r - 1, c);
        paintMatrix(r, c + 1);
        paintMatrix(r, c - 1);
    }

    private static boolean isInMatrix(int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
