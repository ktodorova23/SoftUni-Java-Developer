import java.util.Scanner;

public class weekDays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int dayNum = Integer.parseInt(console.nextLine());

        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (dayNum > weekdays.length || dayNum <= 0) {
            System.out.println("Invalid day!");
            return;
        }

        System.out.println(weekdays[dayNum - 1]);
    }
}
