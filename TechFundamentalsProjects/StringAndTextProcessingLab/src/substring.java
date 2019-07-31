import java.util.Scanner;

public class substring {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String wordToRemove = console.nextLine();
        String word = console.nextLine();

        while (word.contains(wordToRemove)) {
            word = word.replace(wordToRemove, "");
        }

        System.out.println(word);
    }
}
