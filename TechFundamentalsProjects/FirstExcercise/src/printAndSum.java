import java.util.Scanner;

public class printAndSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int start = Integer.parseInt(console.nextLine());
        int end = Integer.parseInt(console.nextLine());

        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i;
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
