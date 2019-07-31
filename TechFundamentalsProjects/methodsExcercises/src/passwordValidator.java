import java.util.Scanner;

public class passwordValidator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String password = console.nextLine();

        if (getCharsCount(password) && checkForDigits(password) && checkPasswordSymbols(password)) {
            System.out.println("Password is valid");
        }

        if (!getCharsCount(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!checkPasswordSymbols(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!checkForDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    static boolean getCharsCount(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        }
        return false;
    }

    static boolean checkPasswordSymbols(String password) {
        for (int i = 0; i < password.length(); i++) {
           if (!Character.isLetterOrDigit(password.charAt(i))) {
               return false;
           }
        }
        return true;
    }

    static boolean checkForDigits(String password) {

        int countDigits = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                countDigits++;
            }
        }

        if (countDigits < 2) {
            return false;
        }
        return true;
    }
}
