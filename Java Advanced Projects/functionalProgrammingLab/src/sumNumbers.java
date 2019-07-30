import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class sumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Arrays.stream(array).sum();

        System.out.println("Count = " + array.length);
        System.out.println("Sum = " + sum);
    }
}
