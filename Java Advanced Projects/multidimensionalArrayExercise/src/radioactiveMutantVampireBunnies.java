import java.util.*;

public class radioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] dimension = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<List<Character>> matrix = new ArrayList<>();

        for (int i = 0; i < dimension[0]; i++) {
            matrix.add(new ArrayList<>());
            char[] data = console.nextLine().toCharArray();
            List<Character> rowData = new ArrayList<>();
            for (char symbol : data) {
                rowData.add(symbol);
            }
            matrix.get(i).addAll(rowData);
        }

        int playerRow = -1, playerCol = -1;

        for (int i = 0; i < dimension[0]; i++) {
            if (matrix.get(i).contains('P')) {
                playerRow = i;
                playerCol = matrix.get(i).indexOf('P');
            }
        }

        String[] commands = console.nextLine().split("");

        boolean playerLoses = false;
        boolean playerWins = false;

        for (int i = 0; i < commands.length; i++) {
            matrix.get(playerRow).set(playerCol, '.');
            matrix = changeMatrix(matrix);
            if (commands[i].equals("U")) {
                if (playerRow - 1 < 0) {
                    playerWins = true;
                } else if (matrix.get(playerRow - 1).get(playerCol) == 'B') {
                    playerLoses = true;
                    playerRow--;
                } else {
                    playerRow--;
                    matrix.get(playerRow).set(playerCol, 'P');
                }
            } else if (commands[i].equals("D")) {
                if (playerRow + 1 > dimension[0] - 1) {
                    playerWins = true;
                } else if (matrix.get(playerRow + 1).get(playerCol) == 'B') {
                    playerLoses = true;
                    playerRow++;
                } else {
                    playerRow++;
                    matrix.get(playerRow).set(playerCol, 'P');
                }
            } else if (commands[i].equals("R")) {
                if (playerCol + 1 > dimension[1] - 1) {
                    playerWins = true;
                } else if (matrix.get(playerRow).get(playerCol + 1) == 'B') {
                    playerLoses = true;
                    playerCol++;
                } else {
                    playerCol++;
                    matrix.get(playerRow).set(playerCol, 'P');
                }
            } else {
                if (playerCol - 1 < 0) {
                    playerWins = true;
                } else if (matrix.get(playerRow).get(playerCol - 1) == 'B') {
                    playerLoses = true;
                    playerCol--;
                } else {
                    playerCol--;
                    matrix.get(playerRow).set(playerCol, 'P');
                }
            }
            if (playerWins || playerLoses) {
                break;
            }
        }

        printMatrix(matrix);

        if (playerWins) {
            System.out.println(String.format("won: %d %d", playerRow, playerCol));
        }
        if (playerLoses) {
            System.out.println(String.format("dead: %d %d", playerRow, playerCol));
        }

    }

    private static void printMatrix(List<List<Character>> matrix) {
        for (List<Character> row : matrix) {
            for (Character symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    @SuppressWarnings("Duplicates")
    private static List<List<Character>> changeMatrix(List<List<Character>> matrix) {
        List<List<Character>> newMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            newMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrix.get(i).size(); j++) {
                newMatrix.get(i).add(matrix.get(i).get(j));
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 'B') {
                    if (i - 1 >= 0) {
                        newMatrix.get(i - 1).set(j, 'B');
                    }
                    if (i + 1 < matrix.size()) {
                        newMatrix.get(i + 1).set(j, 'B');
                    }
                    if (j - 1 >= 0) {
                        newMatrix.get(i).set(j - 1, 'B');
                    }
                    if (j + 1 < matrix.get(i).size()) {
                        newMatrix.get(i).set(j + 1, 'B');
                    }
                }
            }
        }
        return newMatrix;
    }
}
