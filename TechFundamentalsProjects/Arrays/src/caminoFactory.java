import java.util.Scanner;

public class caminoFactory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int length = Integer.parseInt(console.nextLine());

        String input = console.nextLine();

        int bestSequenceIndex = 0;
        int bestSequenceSum = 0;
        int[] bestSequence = new int[length];

        boolean bestSequenceIndexBool = false;
        boolean bestSequenceSumBool = false;

        while (!input.equals("Clone them!")) {
            String strNumbers[] = input.split("!+");
            int[] sequence = new int[length];
            for (int i = 0; i < length; i++) {
                sequence[i] = Integer.parseInt(strNumbers[i]);
            }


            for (int i = 0; i < sequence.length; i++) {
                int sum = 0;
                int sequenceIndex = 0;

                for (int j = i + 1; j < sequence.length; j++) {
                    int counter = 1;
                    int maxCounter = 1;
                    sum = sequence[i] + sequence[j];
                    if (sequence[i] == sequence[j]) {
                        counter++;
                    } else {
                        counter = 1;
                    }

                    if (maxCounter < counter) {
                        maxCounter = counter;
                        sequenceIndex = i + 1;
                    }
                    if (bestSequenceSum < sum) {
                        bestSequenceSum = sum;
                        bestSequenceSumBool = true;
                    }
                }
                if (bestSequenceIndex > sequenceIndex) {
                    bestSequenceIndex = sequenceIndex;
                    bestSequenceIndexBool = true;
                }


            }

            if (bestSequenceIndexBool && bestSequenceSumBool) {
                for (int i = 0; i < sequence.length; i++) {
                    bestSequence[i] = sequence[i];
                }
            }

            input = console.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d%n", bestSequenceIndex, bestSequenceSum);
        System.out.println(bestSequence[bestSequence.length] + " ");
    }
}
