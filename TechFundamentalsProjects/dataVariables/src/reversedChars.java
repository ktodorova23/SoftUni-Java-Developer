import java.util.Scanner;

public class reversedChars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char num1 = console.nextLine().charAt(0);
        char num2 = console.nextLine().charAt(0);
        char num3 = console.nextLine().charAt(0);

        System.out.println("" + num3 + " " + num2 + " " + num1);
    }
}
