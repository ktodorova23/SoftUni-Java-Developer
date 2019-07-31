import java.util.Scanner;

public class digitsLettersAndOther {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder chars = new StringBuilder();
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits.append(input.charAt(i));
            } else if (Character.isLetter(input.charAt(i))) {
                chars.append(input.charAt(i));
            } else {
                symbols.append(input.charAt(i));
            }
        }

        System.out.println(digits);
        System.out.println(chars);
        System.out.println(symbols);
    }
}
