package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car) {
        for (Map.Entry<String, Car> carEntry : cars.entrySet()) {
            if (carEntry.getValue().getRegistrationNumber().equals(car.getRegistrationNumber())) {
                return String.format("Car with that registration number, already exists!");
            }
        }

        if (cars.size() >= this.capacity) {
            return String.format("Parking is full!");
        }

        cars.put(car.getMake(), car);
        return String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
    }

    public String removeCar(String registrationNumber) {
        for (Map.Entry<String, Car> entryCar : cars.entrySet()) {
            if (entryCar.getValue().getRegistrationNumber().equals(registrationNumber)) {
                cars.remove(entryCar.getKey());
                return String.format("Successfully removed %s", registrationNumber);
            }
        }

        return String.format("Car with that registration number, doesn't exists!");
    }

    public Car getCar(String registrationNumber) {
        Car car = null;
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            if (entry.getValue().getRegistrationNumber().equals(registrationNumber)) {
                car = entry.getValue();
            }
        }
        return car;
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String registrationNumber : registrationNumbers) {
            for (Map.Entry<String, Car> entryCar : cars.entrySet()) {
                if (entryCar.getValue().getRegistrationNumber().equals(registrationNumber)) {
                    cars.remove(entryCar.getKey());
                }
            }

        }
    }

    public int getCount() {
        return this.cars.size();
    }
}
