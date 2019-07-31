import java.util.Scanner;

public class calculateRectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int firstSide =  Integer.parseInt(console.nextLine());
        int secondSide = Integer.parseInt(console.nextLine());


        System.out.println(calculateArea(firstSide, secondSide));
    }

    private static int calculateArea(int firstSide, int secondSide) {
        return firstSide * secondSide;
    }
}
