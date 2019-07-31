import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bakingFactory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        int bestQuality = 0;
        List<Integer> bestBatch = new ArrayList<>();
        double bestAverageQuality = 0;
        int bestLength = 0;
        int count = 0;

        while (!line.equals("Bake It!")) {
            count++;
            String[] batch = line.split("#");
            int[] currentBatch = new int[batch.length];

            for (int i = 0; i < batch.length; i++) {
                currentBatch[i] = Integer.parseInt(batch[i]);
            }

            int quality = 0;

            for (int i = 0; i < currentBatch.length; i++) {
                quality += currentBatch[i];
            }

            double averageQuality = 0;

            for (int i = 0; i < currentBatch.length; i++) {
                averageQuality += ((double) currentBatch[i] / (double) currentBatch.length);
            }

            if (count == 1) {
                bestQuality = quality;
                bestLength = currentBatch.length;
                bestAverageQuality = averageQuality;
                for (int i = 0; i < currentBatch.length; i++) {
                    bestBatch.add(i, currentBatch[i]);
                }

            }
            if (quality > bestQuality) {
                bestQuality = quality;
                bestLength = currentBatch.length;
                bestAverageQuality = averageQuality;
                if (bestBatch.size() > 0) {
                    bestBatch.removeAll(bestBatch);
                }
                for (int i = 0; i < currentBatch.length; i++) {
                    bestBatch.add(i, currentBatch[i]);
                }
            } else if (quality == bestQuality) {
                if (averageQuality > bestAverageQuality) {
                    if (bestBatch.size() > 0) {
                        bestBatch.removeAll(bestBatch);
                    }
                    for (int i = 0; i < currentBatch.length; i++) {
                        bestBatch.add(i, currentBatch[i]);
                    }
                } else if (averageQuality == bestAverageQuality) ;
                int lenght = currentBatch.length;

                if (lenght < bestLength) {
                    if (bestBatch.size() > 0) {
                        bestBatch.removeAll(bestBatch);
                    }
                    for (int i = 0; i < currentBatch.length; i++) {
                        bestBatch.add(i, currentBatch[i]);
                    }
                }
            }

            line = console.nextLine();
        }

        System.out.printf("Best Batch quality: %d%n", bestQuality);
        bestBatch.forEach(e -> System.out.print(e + " "));
    }
}
