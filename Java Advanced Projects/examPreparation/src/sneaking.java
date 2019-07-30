import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("Duplicates")
public class sneaking {
    public static char[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        room = new char[rows][];

        int playerRow = -1, playerCol = -1;
        int enemyRow = -1, enemyCol = -1;
        for (int i = 0; i < rows; i++) {
            String input = reader.readLine();
            room[i] = input.toCharArray();
            if (input.contains("N")) {
                enemyRow = i;
                enemyCol = input.indexOf("N");
            } else if (input.contains("S")) {
                playerRow = i;
                playerCol = input.indexOf("S");
            }
        }

        char[] commands = reader.readLine().toCharArray();
        for (int i = 0; i < commands.length; i++) {
            moveEnemies(enemyRow);

            if (hasEnemyFromLeft(playerRow, playerCol) || hasEnemyFromRight(playerRow, playerCol)) {
                room[playerRow][playerCol] = 'X';
                loseInformation(playerRow, playerCol);
                return;
            }

            if (commands[i] == 'U') {
                room[playerRow--][playerCol] = '.';
                room[playerRow][playerCol] = 'S';
            } else if (commands[i] == 'D') {
                room[playerRow++][playerCol] = '.';
                room[playerRow][playerCol] = 'S';
            } else if (commands[i] == 'L') {
                room[playerRow][playerCol--] = '.';
                room[playerRow][playerCol] = 'S';
            } else if (commands[i] == 'R') {
                room[playerRow][playerCol++] = '.';
                room[playerRow][playerCol] = 'S';
            }

            if (playerRow == enemyRow) {
                room[enemyRow][enemyCol] = 'X';
                winInformation();
                return;
            }
        }
    }

    private static void moveEnemies(int enemyRow) {
        for (int l = 0; l < room.length; l++) {
            if (l != enemyRow) {
                for (int j = 0; j < room[l].length; j++) {
                    if (room[l][j] == 'b') {
                        if (j + 1 < room[l].length) {
                            room[l][j] = '.';
                            room[l][j + 1] = 'b';
                        } else {
                            room[l][j] = 'd';
                        }
                        break;
                    }
                    if (room[l][j] == 'd') {
                        if (j - 1 >= 0) {
                            room[l][j] = '.';
                            room[l][j - 1] = 'd';
                        } else {
                            room[l][j] = 'b';
                        }
                        break;
                    }
                }
            }
        }
    }

    private static void printRoom() {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean hasEnemyFromRight(int playerRow, int playerCol) {
        for (int i = playerCol + 1; i < room[playerRow].length; i++) {
            if (room[playerRow][i] == 'd') {
                return true;
            }
        }
        return false;
    }

    private static boolean hasEnemyFromLeft(int playerRow, int playerCol) {
        for (int i = 0; i < playerCol; i++) {
            if (room[playerRow][i] == 'b') {
                return true;
            }
        }
        return false;
    }

    private static void loseInformation(int playerRow, int playerCol) {
        System.out.println(String.format("Sam died at %d, %d", playerRow, playerCol));
        printRoom();
    }

    private static void winInformation() {
        System.out.println("Nikoladze killed!");
        printRoom();
    }
}
