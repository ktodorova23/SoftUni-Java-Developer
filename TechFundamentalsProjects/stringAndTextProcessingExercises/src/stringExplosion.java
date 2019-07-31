import java.util.Scanner;

public class stringExplosion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder input = new StringBuilder(console.nextLine());

        for (int i = input.length() - 1; i >= 0; i--) {
            if (Character.isDigit(input.charAt(i))) {
                int number = Integer.parseInt(Character.toString(input.charAt(i)));

                if (number == 0) {
                    continue;
                } else {
                    String residual = input.substring(i);
                    residual = residual.replaceAll(">", "");
                    if (residual.length() < number) {
                        for (int j = i; j < input.length(); j++) {
                            if (input.charAt(j) != '>') {
                                input.deleteCharAt(j);
                            }
                        }

                        break;
                    } else {
                        while (number > 0) {
                            if (!(input.charAt(i) == '>')) {
                                input.deleteCharAt(i);
                            } else {
                                i++;
                                continue;
                            }
                            number--;
                        }
                    }
                }

            }
        }

        System.out.println(input);
    }
}
