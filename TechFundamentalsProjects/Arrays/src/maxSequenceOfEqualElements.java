import java.util.Scanner;

public class maxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] numsAsString = console.nextLine().split(" ");

        int[] numbers = new int[numsAsString.length];

        for (int i = 0; i < numsAsString.length; i++) {
            numbers[i] = Integer.parseInt(numsAsString[i]);
        }

        int counter = 1;
        int maxCounter = 1;
        int bestIndex = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                counter++;
            } else {
                counter = 1;
            }

            if (maxCounter < counter) {
                maxCounter = counter;
                bestIndex = i + 1;
            }
        }

        int begin = (bestIndex - maxCounter) + 1;

        for (int i = begin; i < begin + maxCounter; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
