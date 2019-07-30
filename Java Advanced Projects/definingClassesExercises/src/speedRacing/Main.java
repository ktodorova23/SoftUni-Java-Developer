package speedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        Car car = null;

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        while (rows-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");

            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double cost = Double.parseDouble(tokens[2]);

            car = new Car(model, fuel, cost);
            cars.put(model, car);
        }

        String line = console.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            if (!cars.get(model).canTravelDistance(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
            line = console.nextLine();
        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.println(entry.getValue().getInfo());;
        }
    }
}
