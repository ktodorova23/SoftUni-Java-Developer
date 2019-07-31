import java.util.Scanner;

public class vowelsCount {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine().toLowerCase();

        System.out.println(countVowels(input));
    }

    static int countVowels (String input) {

        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)) {
                case 'a':
                    count++;
                    break;

                case 'e':
                    count++;
                    break;

                case 'i':
                    count++;
                    break;

                case 'o':
                    count++;
                    break;

                case 'u':
                    count++;
                    break;
            }
        }
        return count;
    }
}
