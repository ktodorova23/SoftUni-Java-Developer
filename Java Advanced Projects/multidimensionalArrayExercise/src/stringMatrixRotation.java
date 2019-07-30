import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringMatrixRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] rotationCommand = console.nextLine().split("[()]+");

        int degrees = Integer.parseInt(rotationCommand[1]) % 360;

        String line = console.nextLine();

        ArrayList<String> words = new ArrayList<>();
        int maxLength = line.length();

        while (!line.equals("END")) {
            words.add(line);
            line = console.nextLine();
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        char[][] matrix = new char[words.size()][maxLength];

        for (int r = 0; r < words.size(); r++) {
            for (int c = 0; c < maxLength; c++) {
                if (c > words.get(r).length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = words.get(r).charAt(c);
                }
            }
        }

        if (degrees == 90) {
            for (int c = 0; c < maxLength; c++) {
                for (int r = matrix.length - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                for (int c = matrix[r].length - 1; c >=0 ; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int c = maxLength - 1; c >= 0; c--) {
                for (int r = 0; r < matrix.length; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }

    }
}
