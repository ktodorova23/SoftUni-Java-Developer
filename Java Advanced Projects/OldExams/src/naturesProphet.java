import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class naturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] garden = new int[rows][cols];

        String line;

        while (!"Bloom Bloom Plow".equals(line = reader.readLine())) {
            int[] coordinates = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            garden[coordinates[0]][coordinates[1]] = 1;
        }
        garden = bloom(garden);

        printGarden(garden);
    }

    private static void printGarden(int[][] garden) {
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden.length; j++) {
                System.out.print(garden[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] bloom(int[][] garden) {
        int[][] newGarden = new int[garden.length][garden.length];

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                if (garden[i][j] == 1) {
                    for (int k = 0; k < newGarden.length; k++) {
                        newGarden[i][k]++;
                        newGarden[k][j]++;
                    }
                    newGarden[i][j]--;
                }
            }
        }
        return newGarden;
    }
}
