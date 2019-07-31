import java.util.Scanner;

public class stringExplosion2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String text = console.nextLine();

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == '>') {
                i++;
                result += symbol;
                int explosion = text.charAt(i) - '0';
                explosion--;
                while (explosion > 0 && i < text.length() - 1) {
                    i++;
                    symbol = text.charAt(i);
                    if (symbol == '>') {
                        result += symbol;
                        i++;
                        explosion += text.charAt(i) - '0';
                        explosion--;
                        continue;
                    }
                    explosion--;
                }

            } else {
                result += symbol;
            }
        }
        System.out.println(result);
    }
}
