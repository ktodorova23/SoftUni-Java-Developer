import java.util.Scanner;

public class passed {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double grade = Double.parseDouble(console.nextLine());

        if (grade >= 3.00) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
