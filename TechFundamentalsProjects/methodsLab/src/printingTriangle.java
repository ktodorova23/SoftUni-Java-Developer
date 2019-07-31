import java.util.Scanner;

public class printingTriangle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int num = Integer.parseInt(console.nextLine());

        for (int i = 0; i < num; i++) {
            System.out.print(repeatNum(num, i + 1));
            System.out.println();
        }

        for (int i = 0; i < num - 1; i++) {
            System.out.print(repeatNum(num, num - i - 1));
            System.out.println();
        }
    }

    static String repeatNum (int num, int count) {
        String text = "";

        for (int i = 1; i <= count; i++) {
            text += i + " ";
        }
        return text;
    }
}
