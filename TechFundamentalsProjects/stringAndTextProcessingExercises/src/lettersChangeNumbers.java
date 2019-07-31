import jdk.nashorn.api.tree.ForInLoopTree;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;

public class lettersChangeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split("\\s+");

        List<Character> lower = new ArrayList<>();
        char[] lowerAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (Character letter:lowerAlphabet) {
            lower.add(letter);
        }

        char[] upperAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        List<Character> upper = new ArrayList<>();
        for (Character letter:upperAlphabet) {
            upper.add(letter);
        }

        double result = 0;

        for (int i = 0; i < input.length; i++) {
            char[] current = input[i].toCharArray();
            char firstSymbol = current[0];
            char lastSymbol = current[current.length - 1];
            String num = "";
            for (int j = 1; j <= current.length - 2; j++) {
                num += current[j];
            }
            int number = Integer.parseInt(num);

            double tempResult = 0;
            double position = 0;

            if (upper.contains(firstSymbol)) {
                position = upper.indexOf(firstSymbol) + 1;
                tempResult = number / position;
            } else {
                position = lower.indexOf(firstSymbol) + 1;
                tempResult = number * position;
            }

            if (upper.contains(lastSymbol)) {
                position = upper.indexOf(lastSymbol) + 1;
                tempResult -= position;
            } else {
                position = lower.indexOf(lastSymbol) + 1;
                tempResult += position;
            }

            result += tempResult;
        }

        System.out.println(String.format("%.2f", result));
    }
}
