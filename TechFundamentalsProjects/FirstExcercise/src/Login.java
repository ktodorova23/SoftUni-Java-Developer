import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String username = console.nextLine();

        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }

        String inputPassword = console.nextLine();

        int attempt = 1;

        while (!inputPassword.equals(password)) {
            attempt++;
            System.out.println("Incorrect password. Try again.");
            inputPassword = console.nextLine();
            if (attempt == 4) {
                break;
            }
        }
        if (inputPassword.equals(password)) {
            System.out.println("User " + username + " logged in.");
        } else {
            System.out.println("User " + username + " blocked!");
        }
    }
}
