import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        repeatInput(number);
    }

    static String repeatInput (int n) {
        String text = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return text;
    }
}
