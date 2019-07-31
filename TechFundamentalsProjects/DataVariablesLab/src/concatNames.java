import java.util.Scanner;

public class concatNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String firstname = console.nextLine();
        String lastName = console.nextLine();
        String delimiter = console.nextLine();

        System.out.println(String.format("%s%s%s", firstname,delimiter, lastName));
    }
}
