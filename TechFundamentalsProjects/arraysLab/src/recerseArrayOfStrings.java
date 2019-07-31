import java.util.Scanner;

public class recerseArrayOfStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(" ");

        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
