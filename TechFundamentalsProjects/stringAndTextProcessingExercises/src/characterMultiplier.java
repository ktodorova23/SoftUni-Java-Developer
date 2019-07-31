import java.util.Scanner;

public class characterMultiplier {
    public static void main(String[] args) {

    Scanner console = new Scanner(System.in);

    String[] input = console.nextLine().split("\\s+");

    int length = Math.min(input[0].length(), input[1].length());
    int result = 0;

        for (int i = 0; i < length; i++) {
            result += input[0].charAt(i) * input[1].charAt(i);
        }

        if (input[0].length() > input[1].length()) {
            for (int i = length; i < input[0].length(); i++) {
                result += input[0].charAt(i);
            }
        } else if ( input[1].length() > input[0].length()) {
            for (int i = length; i < input[1].length(); i++) {
                result += input[1].charAt(i);
            }
        }

        System.out.println(result);

    }
}
