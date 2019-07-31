import java.util.Scanner;

public class bakingMasterclass {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double budget = Double.parseDouble(console.nextLine());
        int students = Integer.parseInt(console.nextLine());
        double flourPrice = Double.parseDouble(console.nextLine());
        double eggsPrice = Double.parseDouble(console.nextLine());
        double apronPrice = Double.parseDouble(console.nextLine());

        int freePackageOfFlour = students / 5;
        double neededMoney = apronPrice * (students + Math.ceil(students * 0.20)) + eggsPrice * 10 * students + flourPrice * (students - freePackageOfFlour);

       if (neededMoney <= budget) {
           System.out.printf("Items purchased for %.2f$.", neededMoney);
       } else {
           double difference = neededMoney - budget;
           System.out.printf("%.2f$ more needed.", difference);
       }
    }
}
