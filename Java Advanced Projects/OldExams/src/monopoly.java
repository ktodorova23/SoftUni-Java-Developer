import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class monopoly {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int countHotels = 0;
        int money = 50;

        char[][] field = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] rowData = reader.readLine().split("");
            for (int j = 0; j < cols; j++) {
                field[i][j] = rowData[j].charAt(0);
            }
        }

        int turns = 0;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    turns++;
                    if (field[i][j] == 'H') {
                        countHotels++;
                        System.out.println(String.format("Bought a hotel for %d. Total hotels: %d.", money, countHotels));
                        money = 0;
                        money += countHotels * 10;
                    } else if (field[i][j] == 'J') {
                        System.out.println(String.format("Gone to jail at turn %d.", turns - 1));
                        turns+=2;
                        money += (countHotels * 10) * 3;
                    } else if (field[i][j] == 'F') {
                        money += countHotels * 10;
                        continue;
                    } else if (field[i][j] == 'S') {
                        //Might come up with an exception
                        if (((i + 1) * (j + 1)) >= money) {
                            System.out.println(String.format("Spent %d money at the shop.", money));
                            money = 0;
                        } else {
                            System.out.println(String.format("Spent %d money at the shop.", (i + 1) * (j + 1)));
                            money -= ((i + 1) * (j + 1));
                        }
                        money += countHotels * 10;
                    }
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    turns++;
                    if (field[i][j] == 'H') {
                        countHotels++;
                        System.out.println(String.format("Bought a hotel for %d. Total hotels: %d.", money, countHotels));
                        money = 0;
                        money += countHotels * 10;
                    } else if (field[i][j] == 'J') {
                        System.out.println(String.format("Gone to jail at turn %d.", turns - 1));
                        turns+=2;
                        money += (countHotels * 10) * 3;
                    } else if (field[i][j] == 'F') {
                        money += countHotels * 10;
                        continue;
                    } else if (field[i][j] == 'S') {
                        //Might come up with an exception
                        if (((i + 1) * (j + 1)) >= money) {
                            System.out.println(String.format("Spent %d money at the shop.", money));
                            money = 0;
                        } else {
                            System.out.println(String.format("Spent %d money at the shop.", (i + 1) * (j + 1)));
                            money -= ((i + 1) * (j + 1));
                        }
                        money += countHotels * 10;
                    }
                }
            }
        }

        System.out.println("Turns " + turns);
        System.out.println("Money " + money);
    }
}
