import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        Pattern pattern = Pattern.compile("(^|(?<=\\s))[A-Za-z][A-Za-z._-]+@[a-z-]+.[a-z]+\\.[a-z]++($|(?=[,\\.\\s]))");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
