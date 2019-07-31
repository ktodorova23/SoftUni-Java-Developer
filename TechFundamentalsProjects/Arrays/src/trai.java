import java.util.Scanner;

public class trai {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int wagons = Integer.parseInt(console.nextLine());

        int [] passengers = new int[wagons];
        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            passengers [i] = Integer.parseInt(console.nextLine());
            sum += passengers [i];
        }
        for (int i = 0; i < passengers.length; i++) {
            System.out.print(passengers[i] + " ");
        }

        System.out.println();
        System.out.println(sum);
    }
}
