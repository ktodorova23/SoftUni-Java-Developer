import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matchFullName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(", ");

        Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$");
        for (String str:input) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                System.out.print(str + " ");
            }
        }
    }
}
