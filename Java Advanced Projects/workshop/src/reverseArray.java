import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        reverse(array, array.length - 1);
    }

    public static void reverse(int[] array, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(array[index] + " ");

        reverse(array, index - 1);
    }
}
