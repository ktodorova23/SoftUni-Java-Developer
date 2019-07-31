import java.util.Scanner;

public class arrayRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");
        int rotations = Integer.parseInt(console.nextLine());

        rotations = rotations % input.length;

        for (int i = 0; i < rotations; i++) {
            String element = input[0];
            for (int j = 0; j < input.length - 1; j++) {
                input[j] = input[j + 1];
            }
            input[input.length-1] = element;
        }

        for (String anInput : input) {
            System.out.print(anInput + " ");
        }
    }
}
