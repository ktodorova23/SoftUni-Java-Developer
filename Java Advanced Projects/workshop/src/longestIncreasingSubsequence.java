import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class longestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lengths = new int[sequence.length];
        int[] prevs = new int[sequence.length];

        int maxLength = 1;
        int maxIndex = -1;
        for (int i = 0; i < sequence.length; i++) {
            int bestLength = 1;
            int index = -1;

            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i] && bestLength < lengths[j] + 1) {
                    bestLength = lengths[j] + 1;
                    index = j;
                }
            }

            lengths[i] = bestLength;
            prevs[i] = index;

            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        int[] result = new int[maxLength];
        int index = maxLength - 1;
        while (maxIndex != -1) {
            result[index--] = sequence[maxIndex];
            maxIndex = prevs[maxIndex];
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
