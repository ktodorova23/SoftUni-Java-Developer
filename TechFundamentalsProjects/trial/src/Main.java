import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        int bestSum = 0;
        int[] bestSequence = new int[number];
        int seqCounter = 0;
        int bestSeqCounter = 0;
        int maxCount = 1;
        String line = console.nextLine();
        while (!line.equals("Clone them!")) {
            seqCounter++;
            int[] sequence = Arrays.stream(line.split("!+")).mapToInt(Integer::parseInt).toArray();
            int count = 1;
            int sum = 0;
            for (int num:sequence) {
                sum += num;
            }

            for (int i = 0; i < sequence.length - 1; i++) {
                if (sequence[i] == sequence[i + 1]) {
                    count++;
                } else {
                    count = 1;
                }

                if (maxCount < count) {
                    maxCount = count;
                    bestSeqCounter = seqCounter;
                    bestSequence = sequence;
                    bestSum = sum;
                } else if (maxCount == count) {
                    if (bestSum < sum) {
                        bestSeqCounter = seqCounter;
                        bestSequence = sequence;
                        bestSum = sum;
                    }
                }
            }

            if (seqCounter == 1) {
                maxCount = count;
                bestSeqCounter = seqCounter;
                bestSequence = sequence;
                bestSum = sum;
            }

            line = console.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSeqCounter, bestSum);
        for (int element:bestSequence) {
            System.out.print(element + " ");
        }
    }
}
