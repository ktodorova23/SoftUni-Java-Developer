import java.util.Scanner;

public class palindromeNumSecondTry {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        while (!input.equals("END")) {
            boolean isPalindrome = true;
            for (int i = 0; i < input.length() / 2; i++) {
                int firstNum = -1;
                int secondNum = -1;
                for (int j = i; j < i+1; j++) {
                    firstNum = input.charAt(j);
                }
                for (int j = input.length() - 1 - i; j > input.length() - i - 2 ; j--) {
                    secondNum = input.charAt(j);
                }

                if (firstNum != secondNum) {
                    isPalindrome = false;
                }

                if (!isPalindrome) {
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = console.nextLine();
        }
    }
}
