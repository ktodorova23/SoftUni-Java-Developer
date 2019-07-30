package vehicles;

public class Bus extends VehicleImpl {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        this.setFuelConsuption(this.getFuelConsumption() + 1.4);
        String result = driveEmpty(distance);
        this.setFuelConsuption(this.getFuelConsumption() - 1.4);
        return result;

    }

    public String driveEmpty(double distance) {
        return "Bus " + super.drive(distance);
    }
}
