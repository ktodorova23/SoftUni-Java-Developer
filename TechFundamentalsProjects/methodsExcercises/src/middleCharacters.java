import java.util.Scanner;

public class middleCharacters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        System.out.println(getMiddleSymbols(input));
    }

    static String getMiddleSymbols (String i) {
        String result = "";
        int middleIndex = i.length() / 2;

        if (i.length()% 2 == 0) {
            result += i.charAt(middleIndex - 1);
            result += i.charAt(middleIndex);
        } else {
            result += i.charAt(middleIndex);
        }
        return result;
    }
}
