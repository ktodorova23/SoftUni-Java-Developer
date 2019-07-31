import java.util.Scanner;

public class reverseStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String word = console.nextLine();

        while (!word.equals("end")) {
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reversedWord.append(word.charAt(i));
            }
            System.out.println(String.format("%s = %s", word, reversedWord.toString()));
            word = console.nextLine();
        }
    }
}
