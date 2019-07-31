import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int lenght = Integer.parseInt(console.nextLine());

        String input = console.nextLine();

        int counter = 0;
        int sequenceCounter = 1;
        int bestCounter = 1;
        int lastIndex = 0;
        String[] bestSample = new String[lenght];

        while (!input.equals("Clone them!")) {
            counter++;
//            int sum
            String[] sample = input.split("!+");
            int[] numericSample = new int[lenght];

            for (int i = 0; i < lenght; i++) {
                numericSample[i] = Integer.parseInt(sample[i]);
            }
            for (int i = 0; i < numericSample.length; i++) {
                if (numericSample[i] == numericSample[i + 1]) {
                    sequenceCounter++;
                } else {
                    sequenceCounter = 1;
                }

                if (sequenceCounter > bestCounter) {
                    bestCounter = sequenceCounter;
                    for (int j = 0; j < lenght; j++) {
                        bestSample[i] = sample[i];
                    }
                    lastIndex = i + 1;
                } else if (sequenceCounter == bestCounter) {
                    lastIndex = 0;
                }

                if (sequenceCounter == bestCounter) {

                }
            }


            input = console.nextLine();
        }
    }
}

