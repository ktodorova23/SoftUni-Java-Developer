import java.text.DecimalFormat;
import java.util.Scanner;

public class inTime {
    public static void main(String[] args) {
        Scanner pesho = new Scanner(System.in);
        int examHour = Integer.parseInt(pesho.nextLine());
        int examMinute = Integer.parseInt(pesho.nextLine());
        int arrivalHour = Integer.parseInt(pesho.nextLine());
        int arrivalMinute = Integer.parseInt(pesho.nextLine());


        int examMinutes = examHour * 60 + examMinute;
        int arrivalMinutes = arrivalHour * 60 + arrivalMinute;

        if (arrivalMinutes < examMinutes - 30) {
            System.out.println("Early");
            int difference = examMinutes - arrivalMinutes;
            if (difference < 60) {
                System.out.printf("%d minutes before the start", difference);
            } else {
                System.out.printf("%d:%s hours before the start", difference / 60,
                        (difference % 60 > 9)
                                ? "" + difference % 60
                                : "0" + difference % 60);
            }
        } else if (arrivalMinutes > examMinutes) {
            int difference = arrivalMinutes - examMinutes;
            if (difference < 60) {
                System.out.printf("Late%n%d minutes after the start", difference);
            } else {
                System.out.printf("Late%n%d:%s hours after the start", difference / 60,
                        (difference % 60 > 9)
                                ? "" + difference % 60
                                : "0" + difference % 60);
            }
        } else {
            System.out.println("On time");
            if (examMinutes - arrivalMinutes != 0) {
                System.out.printf("%d minutes before the start", examMinutes - arrivalMinutes);
            }
        }
    }
}