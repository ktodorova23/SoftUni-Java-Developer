package carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int engineData = Integer.parseInt(console.nextLine());

        Engine engine = null;

        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        while (engineData-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");

            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else {
                engine = new Engine(model, power, Integer.parseInt(tokens[2]), tokens[3]);
            }

//            ???
            engines.put(model, engine);
        }

        int carData = Integer.parseInt(console.nextLine());

        Car car = null;
        while (carData-- > 0) {
            String[] tokens = console.nextLine().split("\\s+");

            String model = tokens[0];
            String engineName = tokens[1];
            Engine engine1 = engines.get(engineName);

            if (tokens.length == 2) {
                car = new Car(model, engine1);
            } else if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine1, weight);
                } catch (NumberFormatException e) {
                    car = new Car(model, engine1, tokens[2]);
                }
            } else {
                car = new Car(model, engine1, Integer.parseInt(tokens[2]), tokens[3]);
            }

            cars.add(car);
        }

        for (Car car1 : cars) {
            System.out.print(car1.getInfo());
        }
    }
}
