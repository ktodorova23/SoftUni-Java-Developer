import java.util.Scanner;

public class pokeMon {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = Integer.parseInt(console.nextLine());
        int M = Integer.parseInt(console.nextLine());
        int Y = Integer.parseInt(console.nextLine());


        int originalN = N;
        int count = 0;
        int subtractedNum = 0;

        while (N >= M) {
            count++;
            subtractedNum = N - M;
            N = subtractedNum;

            if (N == (double) originalN / 2 && Y != 0) {
                N /= Y;
            }
        }

        System.out.printf("%d%n%d", N, count);
    }
}
