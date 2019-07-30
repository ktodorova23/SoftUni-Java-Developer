import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String[] commands = reader.readLine().split(", ");

        List<List<String>> field = new ArrayList<>();

        int row = -1, col = -1;
        int totalFood = 0;
        for (int i = 0; i < size; i++) {
            field.add(new ArrayList<>());
            List<String> rowData = Arrays.stream(reader.readLine().split("\\s+"))
                    .collect(Collectors.toList());
            field.get(i).addAll(rowData);
            if (rowData.contains("s")) {
                row = i;
                col = rowData.indexOf("s");
            }

            if (rowData.contains("f")) {
                for (int j = 0; j < rowData.size(); j++) {
                    if (field.get(i).get(j).equals("f")) {
                        totalFood++;
                    }
                }
            }
        }

        int length = 1;

        for (int i = 0; i < commands.length; i++) {
            field.get(row).set(col, "*");
            switch (commands[i]) {
                case "left":
                    if (col - 1 < 0) {
                        col = size - 1;
                    } else {
                        col--;
                    }
                    break;
                case "right":
                    if (col + 1 == size) {
                        col = 0;
                    } else {
                        col++;
                    }
                    break;
                case "up":
                    if (row - 1 < 0) {
                        row = size - 1;
                    } else {
                        row--;
                    }
                    break;
                case "down":
                    if (row + 1 == size) {
                        row = 0;
                    } else {
                        row++;
                    }
                    break;
            }
            if (field.get(row).get(col).equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (field.get(row).get(col).equals("f")) {
                length++;
                totalFood--;
                if (totalFood == 0) {
                    System.out.println(String.format("You win! Final snake length is %d", length));
                    return;
                }
            }
            field.get(row).set(col, "s");
        }
        System.out.println(String.format("You lose! There is still %d food to be eaten.", totalFood));
    }
}
