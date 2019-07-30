import java.util.Arrays;
import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] firstData = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstRows = firstData[0];

        int[][] firstMatrix = new int[firstRows][];

        for (int i = 0; i < firstRows; i++) {
            int[] rowData = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[i] = rowData;
        }

        int[] secondData = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondRows = secondData[0];

        int[][] secondMatrix = new int[secondRows][];

        for (int i = 0; i < secondRows; i++) {
            int[] rowData = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[i] = rowData;
        }

        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
