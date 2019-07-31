import java.util.Scanner;

public class padawanEquipment {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double money = Double.parseDouble(console.nextLine());
        int students = Integer.parseInt(console.nextLine());
        double priceLightsabers = Double.parseDouble(console.nextLine());
        double priceRobes = Double.parseDouble(console.nextLine());
        double pricebelts = Double.parseDouble(console.nextLine());

        int freeBelts = students / 6;

        double priceOfNeededEquipment = priceLightsabers * (students + Math.ceil (students * 0.1)) + priceRobes * students + pricebelts * (students - freeBelts);
        double difference = priceOfNeededEquipment - money;

        if (priceOfNeededEquipment <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", priceOfNeededEquipment);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", difference);
        }
    }
}
