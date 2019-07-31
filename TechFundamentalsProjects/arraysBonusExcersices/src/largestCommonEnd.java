import java.util.Scanner;

public class largestCommonEnd {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] firstRow = console.nextLine().split(" ");
        String[] secondRow = console.nextLine().split(" ");

        int counterLeft = 0;
        for (int i = 0; i < Math.min(firstRow.length, secondRow.length); i++) {
            String upperLeft = "";
            for (int j = i; j < i + 1; j++) {
                upperLeft = firstRow[i];
            }

            String lowerLeft = "";
            for (int j = i; j < i + 1; j++) {
                lowerLeft = secondRow[i];
            }

            if (upperLeft.equals(lowerLeft)) {
                counterLeft++;
            } else {
                break;
            }
        }

        int counterRight = 0;
        for (int i = 0; i < Math.min(firstRow.length, secondRow.length); i++) {
            String upperRight = "";
            for (int j = firstRow.length - 1 - i; j > firstRow.length - i - 2; j--) {
                upperRight = firstRow[j];
            }

            String lowerRight = "";
            for (int j = secondRow.length - 1 - i; j > secondRow.length - 2 - i; j--) {
                lowerRight = secondRow[j];
            }

            if (upperRight.equals(lowerRight)) {
                counterRight++;
            } else {
                break;
            }
        }

        int bestNumber = 0;

        if (counterLeft > counterRight) {
            bestNumber = counterLeft;
        } else {
            bestNumber = counterRight;
        }

        System.out.println(bestNumber);

    }
}
