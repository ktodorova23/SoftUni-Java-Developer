import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class excelFunctions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());

        List<List<String>> table = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            table.add(new ArrayList<>());
            table.set(i, Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList()));
        }

        String[] command = reader.readLine().split("\\s+");

        if (command[0].equals("hide")) {
            int columnToDelete = getHeaderColumn(table, command[1]);
                for (int i = 0; i < table.size(); i++) {
                    table.get(i).remove(columnToDelete);
                }
            printTable(table);
        } else if (command[0].equals("sort")) {
            int columnToSort = getHeaderColumn(table, command[1]);
                for (int i = 1; i < table.size() - 1; i++) {
                    if (table.get(i).get(columnToSort).compareTo(table.get(i + 1).get(columnToSort)) > 0) {
                        Collections.swap(table, i, i + 1);
                    }
                }
            printTable(table);
        } else {
            int columnToFilter = getHeaderColumn(table, command[1]);
                System.out.println(String.join(" | ", table.get(0)));
            for (int i = 0; i < rows; i++) {
                if (table.get(i).get(columnToFilter).equals(command[2])) {
                    System.out.println(String.join(" | ", table.get(i)));
                }
            }
        }
    }

    private static void printTable(List<List<String>> table) {
        for (int i = 0; i < table.size(); i++) {
            System.out.println(String.join(" | ", table.get(i)));
        }
    }

    private static int getHeaderColumn(List<List<String>> table, String header) {
        int column = -1;
        for (int i = 0; i < table.get(0).size(); i++) {
            if (table.get(0).get(i).equals(header)) {
                column = i;
                break;
            }
        }
        return column;
    }
}
