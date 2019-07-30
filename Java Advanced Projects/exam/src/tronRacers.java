import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("Duplicates")
public class tronRacers {
    public static char[][] field;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int dimensions = Integer.parseInt(reader.readLine());

        field = new char[dimensions][dimensions];

        int firstRow = -1, firstCol = -1;
        int secondRow = -1, secondCol = -1;

        for (int i = 0; i < dimensions; i++) {
            String input = reader.readLine();
            field[i] = input.toCharArray();
            if (input.contains("f")) {
                firstRow = i;
                firstCol = input.indexOf("f");
            } else if (input.contains("s")) {
                secondRow = i;
                secondCol = input.indexOf("s");
            }
        }

        while (true) {
            String[] commands = reader.readLine().split("\\s+");
            String firstCommand = commands[0];
            String secondCommand = commands[1];

            boolean firstIsDead = false;
            Initial:
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (firstCommand.equals("down")) {
                        if (firstRow + 1 == field.length) {
                            firstRow = 0;
                        } else {
                            firstRow++;
                        }
                        if (field[firstRow][firstCol] == 's') {
                            field[firstRow][firstCol] = 'x';
                            firstIsDead = true;
                            break Initial;
                        }
                        field[firstRow][firstCol] = 'f';
                        break Initial;
                    } else if (firstCommand.equals("up")) {
                        if (firstRow - 1 == -1) {
                            firstRow = field.length - 1;
                        } else {
                            firstRow--;
                        }
                        if (field[firstRow][firstCol] == 's') {
                            field[firstRow][firstCol] = 'x';
                            firstIsDead = true;
                            break Initial;
                        }
                        field[firstRow][firstCol] = 'f';
                        break Initial;
                    } else if (firstCommand.equals("left")) {
                        if (firstCol - 1 == -1) {
                            firstCol = field[firstRow].length - 1;
                        } else {
                            firstCol--;
                        }
                        if (field[firstRow][firstCol] == 's') {
                            field[firstRow][firstCol] = 'x';
                            firstIsDead = true;
                            break Initial;
                        }
                        field[firstRow][firstCol] = 'f';
                        break Initial;
                    } else {
                        if (firstCol + 1 == field[firstRow].length) {
                            firstCol = 0;
                        } else {
                            firstCol++;
                        }
                        if (field[firstRow][firstCol] == 's') {
                            field[firstRow][firstCol] = 'x';
                            firstIsDead = true;
                            break Initial;
                        }
                        field[firstRow][firstCol] = 'f';
                        break Initial;
                    }
                }
            }
            boolean secondIsDead = false;
            if (!firstIsDead) {
                Second:
                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field[i].length; j++) {
                        if (secondCommand.equals("down")) {
                            if (secondRow + 1 == field.length) {
                                secondRow = 0;
                            } else {
                                secondRow++;
                            }
                            if (field[secondRow][secondCol] == 'f') {
                                field[secondRow][secondCol] = 'x';
                                secondIsDead = true;
                                break Second;
                            }
                            field[secondRow][secondCol] = 's';
                            break Second;
                        } else if (secondCommand.equals("up")) {
                            if (secondRow - 1 < 0) {
                                secondRow = field.length - 1;
                            } else {
                                secondRow--;
                            }
                            if (field[secondRow][secondCol] == 'f') {
                                field[secondRow][secondCol] = 'x';
                                secondIsDead = true;
                                break Second;
                            }
                            field[secondRow][secondCol] = 's';
                            break Second;
                        } else if (secondCommand.equals("left")) {
                            if (secondCol - 1 == -1) {
                                secondCol = field[secondRow].length - 1;
                            } else {
                                secondCol--;
                            }
                            if (field[secondRow][secondCol] == 'f') {
                                field[secondRow][secondCol] = 'x';
                                secondIsDead = true;
                                break Second;
                            }
                            field[secondRow][secondCol] = 's';
                            break Second;
                        } else {
                            if (secondCol + 1 == field[secondRow].length) {
                                secondCol = 0;
                            } else {
                                secondCol++;
                            }
                            if (field[secondRow][secondCol] == 'f') {
                                field[secondRow][secondCol] = 'x';
                                secondIsDead = true;
                                break Second;
                            }
                            field[secondRow][secondCol] = 's';
                            break Second;
                        }
                    }
                }
            }

            if (firstIsDead || secondIsDead) {
                printField();
                break;
            }

        }

    }

    private static void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
