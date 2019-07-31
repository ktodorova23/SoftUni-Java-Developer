import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vehicleCatalogue2 {

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();

        while (!line.equals("End")) {


            line = console.nextLine();
        }
    }
}
