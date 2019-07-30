
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class connectedAreasInAMatrix {
    private static class Area {
        private int row;
        private int col;
        private int size;

        public Area(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getSize() {
            return size;
        }

        public String toString(int number) {
            return String.format("Area #%d at (%d, %d), size: %d",
                    number, this.row, this.col, this.size);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().replaceAll("[ \t]+", "").toCharArray();
        }

        ArrayList<Area> areas = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '-') {
                    int[] size = new int[1];
                    countSymbols(matrix, i, j, size);

                    Area area = new Area(i, j, size[0]);
                    areas.add(area);
                }
            }
        }

        System.out.println("Total areas found: " + areas.size());
        AtomicInteger number = new AtomicInteger(1);
        areas.stream().sorted((f, s) -> {
            int result = Integer.compare(s.getSize(), f.getSize());
            if (result == 0) {
                result = f.getRow() - s.getRow();
            }
            if (result == 0) {
                result = f.getCol() - s.getCol();
            }
            return result;
        }).forEach(area -> System.out.println(area.toString(number.getAndIncrement())));


    }

    private static void countSymbols(char[][] matrix, int row, int col, int[] size) {
        if (!isInRangeOfMatrix(matrix, row, col) || matrix[row][col] != '-') {
            return;
        }

        size[0]++;
        matrix[row][col] = 'V';

        countSymbols(matrix, row + 1, col, size);
        countSymbols(matrix, row - 1, col, size);
        countSymbols(matrix, row, col + 1, size);
        countSymbols(matrix, row, col - 1, size);
    }

    private static boolean isInRangeOfMatrix(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
