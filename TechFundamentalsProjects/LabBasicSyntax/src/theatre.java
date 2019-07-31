import java.util.Scanner;

public class theatre {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String weekDay = console.nextLine();
        int age = Integer.parseInt(console.nextLine());

        int pricePerOne = -1;

        if (weekDay.equals("Weekday")) {
            if (age >= 0 && age <= 18) {
                pricePerOne = 12;
            } else if (age > 18 && age <= 64) {
                pricePerOne = 18;
            } else if (age > 64 && age <= 122){
                pricePerOne = 12;
            } else {
                System.out.println("Error!");
                return;
            }
        } else if (weekDay.equals("Weekend")) {
            if (age >= 0 && age <= 18) {
                pricePerOne = 15;
            } else if (age > 18 && age <= 64) {
                pricePerOne = 20;
            } else if (age > 64 && age <= 122) {
                pricePerOne = 15;
            } else {
                System.out.println("Error!");
                return;
            }
        } else if (weekDay.equals("Holiday")) {
            if (age >= 0 && age <= 18) {
                pricePerOne = 5;
            } else if (age > 18 && age <= 64) {
                pricePerOne = 12;
            } else if (age > 64 && age <= 122){
                pricePerOne = 10;
            } else {
                System.out.println("Error!");
                return;
            }
        }

        System.out.printf("%d$", pricePerOne);


    }
}
