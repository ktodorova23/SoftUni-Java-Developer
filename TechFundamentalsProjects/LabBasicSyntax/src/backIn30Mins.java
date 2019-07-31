import java.util.Scanner;

public class backIn30Mins {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int hours = Integer.parseInt(console.nextLine());
        int mins = Integer.parseInt(console.nextLine()) + 30;

        if (mins > 59) {
            hours += 1;
            mins -= 60;
        }

        if (hours > 23) {
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, mins);
    }
}
