import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class bombField {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int dimensions = Integer.parseInt(reader.readLine());

        String[] directions = reader.readLine().split(",");

        List<List<String>> field = new ArrayList<>();

        int row = -1, col = -1;

        int totalBombs = 0;
        for (int i = 0; i < dimensions; i++) {
            field.add(new ArrayList<>());
            List<String> rowData = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .collect(Collectors.toList());
            field.get(i).addAll(rowData);
            if (rowData.contains("s")) {
                row = i;
                col = rowData.indexOf("s");
            }
        }

        for (List<String> rows : field) {
            for (String cell : rows) {
                if (cell.equals("B")) {
                    totalBombs++;
                }
            }
        }

        int bombsFoundCounter = 0;
        for (int i = 0; i < directions.length; i++) {
            switch (directions[i]) {
                case "left":
                    if (col - 1 >= 0) {
                        field.get(row).set(col, "+");
                        if (field.get(row).get(col - 1).equals("B")){
                            bombsFoundCounter++;
                            System.out.println("You found a bomb!");
                            if (totalBombs - bombsFoundCounter == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }
                        } else if (field.get(row).get(col - 1).equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs - bombsFoundCounter);
                            return;
                        }

                        field.get(row).set(col - 1, "s");
                        col--;
                    }
                break;
                case "right":
                    if (col + 1 < field.get(row).size()) {
                        field.get(row).set(col, "+");
                        if (field.get(row).get(col + 1).equals("B")){
                            bombsFoundCounter++;
                            System.out.println("You found a bomb!");
                            if (totalBombs - bombsFoundCounter == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }
                        } else if (field.get(row).get(col + 1).equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs - bombsFoundCounter);
                            return;
                        }
                        field.get(row).set(col + 1, "s");
                        col++;
                    }
                break;
                case "up":
                    if (row - 1 >= 0) {
                        field.get(row).set(col, "+");
                        if (field.get(row - 1).get(col).equals("B")) {
                            bombsFoundCounter++;
                            System.out.println("You found a bomb!");
                            if (totalBombs - bombsFoundCounter == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }
                        } else if (field.get(row - 1).get(col).equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs - bombsFoundCounter);
                            return;
                        }
                        field.get(row - 1).set(col, "s");
                        row--;
                    }
                    break;
                case "down":
                    if (row + 1 < field.size()) {
                        field.get(row).set(col, "+");
                        if (field.get(row + 1).get(col).equals("B")) {
                            bombsFoundCounter++;
                            System.out.println("You found a bomb!");
                            if (totalBombs - bombsFoundCounter == 0) {
                                System.out.println("Congratulations! You found all bombs!");
                                return;
                            }
                        } else if (field.get(row + 1).get(col).equals("e")) {
                            System.out.printf("END! %d bombs left on the field", totalBombs - bombsFoundCounter);
                            return;
                        }
                        field.get(row + 1).set(col, "s");
                        row++;
                    }
                    break;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", totalBombs - bombsFoundCounter, row, col);

    }
}
