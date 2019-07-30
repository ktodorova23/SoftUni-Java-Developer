import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class chessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[8][8];

        for (int i = 0; i < board.length; i++) {
            String[] rawData = reader.readLine().split("\\|");
            for (int j = 0; j < rawData.length; j++) {
                board[i][j] = rawData[j].charAt(0);
            }
        }

        int[] startPosition = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int row = startPosition[0];
        int col = startPosition[1];

        String line;
        int invalidMovesCount = 0;
        int boardOutMovesCount = 0;
        Deque<String> piecesTaken = new ArrayDeque<>();

        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split(" -> ");
            int[] parts = Arrays.stream(tokens[1].split("")).mapToInt(Integer::parseInt).toArray();
            int nextRow = parts[0];
            int nextCol = parts[1];

            if (isValidMove(row, col, nextRow, nextCol) && isInRange(nextRow, nextCol)) {
                if (board[nextRow][nextCol] != ' ') {
                    piecesTaken.offer(board[nextRow][nextCol] + "");
                    board[nextRow][nextCol] = ' ';
                }
                row = nextRow;
                col = nextCol;
            } else {
                if (!isValidMove(row, col, nextRow, nextCol)) {
                    invalidMovesCount++;
                    continue;
                }
                if (!isInRange(nextRow, nextCol)) {
                    boardOutMovesCount++;
                }
            }
        }

        System.out.println("Pieces take: " + String.join(", ", piecesTaken));
        System.out.println("Invalid moves: " + invalidMovesCount);
        System.out.println("Board out moves: " + boardOutMovesCount);
    }

    private static boolean isInRange(int nextRow, int nextCol) {
        if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
            return true;
        }
        return false;
    }

    private static boolean isValidMove(int row, int col, int nextRow, int nextCol) {
        if ((nextRow == row - 2 && nextCol == col - 1) ||
                (nextRow == row - 2 && nextCol == col + 1) ||
                (nextRow == row + 2 && nextCol == col - 1) ||
                (nextRow == row + 2 && nextCol == col + 1) ||
                (nextRow == row - 1 && nextCol == col + 2) ||
                (nextRow == row + 1 && nextCol == col + 2) ||
                (nextRow == row - 1 && nextCol == col - 2) ||
                (nextRow == row + 1 && nextCol == col - 2)) {
            return true;
        }
        return false;
    }
}
