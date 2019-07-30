package speedRacing;

public class Car {
    private String model;
    private double fuel;
    private double cost;
    private int distanceTravelled;

    public Car(String model, double fuel, double cost) {
        this.model = model;
        this.fuel = fuel;
        this.cost = cost;
        this.distanceTravelled = 0;
    }

    public boolean canTravelDistance(int distance) {
        double fuelNeeded = distance * this.cost;

        if (this.fuel >= fuelNeeded) {
            this.fuel -= fuelNeeded;
            distanceTravelled += distance;
            return true;
        }
        return false;
    }

    public String getInfo() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTravelled);
    }
}
