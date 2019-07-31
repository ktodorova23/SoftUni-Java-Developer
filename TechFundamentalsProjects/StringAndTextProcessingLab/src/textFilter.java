import java.util.Scanner;

public class textFilter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] banWords = console.nextLine().split(", ");
        String text = console.nextLine();

        for (String banWord: banWords) {
                String stars = banWord.replaceAll(".", "*");
                text = text.replace(banWord, stars);
        }

        System.out.println(text);
    }
}
