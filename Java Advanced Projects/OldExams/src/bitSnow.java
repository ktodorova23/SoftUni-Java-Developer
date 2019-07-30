import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = reader.readLine().split(", ");

        char[][] matrix = new char[inputs.length][16];

        for (int i = 0; i < inputs.length; i++) {
            Arrays.fill(matrix[i], '0');
        }

        List<String> binaryNumbers = new ArrayList<>();
        for (String input : inputs) {
            binaryNumbers.add(Integer.toBinaryString(Integer.parseInt(input)));
        }

        for (int i = 0; i < binaryNumbers.size(); i++) {
            for (int j = 0; j < binaryNumbers.get(i).length(); j++) {
                matrix[i][j + 16 - binaryNumbers.get(i).length()] = binaryNumbers.get(i).charAt(j);
            }
        }

        while (true) {
            boolean flag = false;
            for (int i = matrix.length - 1; i > 0; i--) {
                for (int j = 0; j < 16; j++) {
                    if (matrix[i][j] == '0' && matrix[i - 1][j] == '1') {
                        flag = true;
                        matrix[i][j] = '1';
                        matrix[i - 1][j] = '0';
                    }
                }
            }
            if (!flag) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Long.parseLong(new String(matrix[i]), 2)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
