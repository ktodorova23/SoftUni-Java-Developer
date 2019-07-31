import java.util.Scanner;

public class validUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] usernames = console.nextLine().split(", ");

        for (String username:usernames) {
            if (usernameIsValid(username)) {
                System.out.println(username);
            }
        }
    }

    public static boolean usernameIsValid (String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetterOrDigit(username.charAt(i)) && username.charAt(i) != '-' && username.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }
}
