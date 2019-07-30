import java.util.Scanner;

public class IntersectionOfTwoMatrces {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());
        int cols = Integer.parseInt(console.nextLine());

        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputs = console.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = inputs[col].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] data = console.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                char symbol = data[j].charAt(0);
                if (firstMatrix[i][j] == symbol) {
                    System.out.print(symbol + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
