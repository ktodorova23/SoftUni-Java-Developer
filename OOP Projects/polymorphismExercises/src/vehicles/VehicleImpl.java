package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsuption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsuption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelConsumption () {
        return this.fuelConsumption;
    }
    @Override
    public String drive(double distance) {
        String result = "";
        DecimalFormat df = new DecimalFormat("#.##");

        if (distance * this.fuelConsumption <= this.fuelQuantity) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= distance * this.fuelConsumption;
        } else {
            result = "needs refueling";
        }
        return result;
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
