package rawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = Integer.parseInt(console.nextLine());

        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        while (rows-- > 0){
            String[] tokens = console.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double firstTirePressure = Double.parseDouble(tokens[5]);
            int firstTireAge = Integer.parseInt(tokens[6]);
            double secondTirePressure = Double.parseDouble(tokens[7]);
            int secondTireAge = Integer.parseInt(tokens[8]);
            double thirdTirePressure = Double.parseDouble(tokens[9]);
            int thirdTireAge = Integer.parseInt(tokens[10]);
            double fourthTirePressure = Double.parseDouble(tokens[11]);
            int fourthTireAge = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire firstTire = new Tire(firstTirePressure, firstTireAge);
            Tire secondTire = new Tire(secondTirePressure, secondTireAge);
            Tire thirdTire = new Tire(thirdTirePressure, thirdTireAge);
            Tire fourthTire = new Tire(fourthTirePressure, fourthTireAge);

            List<Tire> tires = new ArrayList<>();
            tires.add(firstTire);
            tires.add(secondTire);
            tires.add(thirdTire);
            tires.add(fourthTire);
            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);
        }

        String line = console.nextLine();

        for (Car car : cars) {
            if (line.equals("fragile")) {
                if (car.getCargo().getType().equals(line)) {
                    for (Tire tire : car.getTires()) {
                        if (tire.getPressure() < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            } else {
                if (car.getCargo().getType().equals(line) && car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }


    }
}
