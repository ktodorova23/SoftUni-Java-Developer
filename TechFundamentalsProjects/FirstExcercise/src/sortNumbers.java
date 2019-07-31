import java.util.Scanner;

public class sortNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = Integer.parseInt(console.nextLine());
        int b = Integer.parseInt(console.nextLine());
        int c = Integer.parseInt(console.nextLine());

        if (a > b && a > c) {
            if (b > c) {
                System.out.printf("%d%n%d%n%d%n", a, b, c);
            } else {
                System.out.printf("%d%n%d%n%d%n", a, c, b);
            }
        } else if (a < b && b > c) {
            if (a > c) {
                System.out.printf("%d%n%d%n%d%n", b, a, c);
            } else {
                System.out.printf("%d%n%d%n%d%n", b, c, a);
            }
        } else {
            if (a > b) {
                System.out.printf("%d%n%d%n%d%n", c, a, b);
            } else {
                System.out.printf("%d%n%d%n%d%n", c, b, a);
            }
        }
    }
}
