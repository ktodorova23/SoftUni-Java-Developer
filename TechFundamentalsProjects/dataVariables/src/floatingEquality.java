import java.util.Scanner;

public class floatingEquality {
    private static final double EPSILON = 0.0000001;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double num1 = Math.abs(Float.parseFloat(console.nextLine()));
        double num2 = Math.abs(Float.parseFloat(console.nextLine()));


        if (equals(num1, num2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

        static boolean equals(double a, double b) {
        if (a==b) return true;
        return Math.abs(a - b) < EPSILON * Math.max(Math.abs(a), Math.abs(b));
    }
//    public static boolean equals(double a, double b, double eps) {
//        if (a == b) return true;
//        return Math.abs(a - b) < eps;
//    }
}
