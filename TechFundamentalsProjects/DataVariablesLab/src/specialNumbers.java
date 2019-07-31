import java.util.Scanner;

public class specialNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

//        int numToOperateWith = number;


        for (int i = 1; i <= number; i++) {
            int numbers = i;
            int sum = 0;
            while (numbers > 0) {
                sum += numbers % 10;
                numbers /= 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }

        }
    }
}
