import java.util.Scanner;

public class repeatString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();
        int count = Integer.parseInt(console.nextLine());

        System.out.println(repeatStr(input, count));
    }

    private static String repeatStr(String input, int count) {
           String text = "";

        for (int i = 0; i < count; i++) {
            text += input;
        }
            return text;
    }
}
