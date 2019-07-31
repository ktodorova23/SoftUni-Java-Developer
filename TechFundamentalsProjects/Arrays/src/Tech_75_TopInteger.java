import java.util.Arrays;
import java.util.Scanner;

public class Tech_75_TopInteger {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        topNumbers(scan.nextInt());
    }

    public static void topNumbers(int input) {

        int[] arr = new int[input + 1];
        for (int i = 1; i < arr.length; i++) {
            //arr[i] = i;
            if ((i / 10 + i % 10)%8 == 0) {

                if (i / 10 % 2 != 0 || (i % 10) % 2 != 0) {
                    System.out.println(i);
                }
            }
        }
    }
}