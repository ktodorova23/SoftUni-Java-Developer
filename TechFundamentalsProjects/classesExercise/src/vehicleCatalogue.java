import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vehicleCatalogue {

    static class Vehicle {
        String typeOfVehicle;
        String model;
        String color;
        int horsePower;

        public String getTypeOfVehicle() {
            return typeOfVehicle;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public Vehicle(String typeOfVehicle, String model, String color, int horsePower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String line = console.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();

        while (!line.equals("End")) {
            String[] data = line.split("\\s+");

            String typeOfVehicle = data[0];
            String model = data[1];
            String color = data[2];
            int horsePower = Integer.parseInt(data[3]);

            Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePower);
            vehicles.add(vehicle);

            line = console.nextLine();
        }

        line = console.nextLine();

        while (!line.equals("Close the Catalogue")) {
            String finalLine = line;
            vehicles.stream()
                    .filter(v -> v.getModel().equals(finalLine))
                    .forEach(veh -> System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n",
                            veh.getTypeOfVehicle().substring(0, 1).toUpperCase() + veh.getTypeOfVehicle().substring(1),
                            veh.getModel(), veh.getColor(), veh.getHorsePower()));

            line = console.nextLine();
        }

        double totalTruckHP = 0;
        double truckVehiclesCount = 0;
        double totalCarHP = 0;
        double carVehiclesCount = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getTypeOfVehicle().equals("truck")) {
                totalTruckHP += vehicle.getHorsePower();
                truckVehiclesCount++;
            } else {
                totalCarHP += vehicle.getHorsePower();
                carVehiclesCount++;
            }
        }

        double averageCarPower = 0;
        double averageTruckPower = 0;

        if (carVehiclesCount > 0) {
            averageCarPower = totalCarHP / carVehiclesCount;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarPower);

        if (truckVehiclesCount > 0) {
            averageTruckPower = totalTruckHP / truckVehiclesCount;
        }
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTruckPower);
    }
}
