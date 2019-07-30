import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class nestedLoops {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        arr = new int[n];

        printNumbers(n, 0);
    }

    private static void printNumbers(int n, int begin) {
        if (begin >= n) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[begin] = i;
            printNumbers(n, begin + 1);
        }
    }
}
