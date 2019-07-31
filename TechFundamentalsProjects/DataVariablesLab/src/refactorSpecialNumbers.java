import java.util.Scanner;

public class refactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int changingNum = i;
            int sum = 0;
            while (changingNum > 0) {
                sum += changingNum % 10;
                changingNum /=  10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }
        }
    }
}
