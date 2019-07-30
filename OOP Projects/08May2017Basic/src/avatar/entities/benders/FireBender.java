package avatar.entities.benders;

public class FireBender extends BenderImpl {
    private double heatAggression;

    public FireBender(String name, long power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public String toString() {
        return String.format("Fire Bender: %s, Power: %d, Heat Aggression: %.2f",
                this.getName(), this.getPower(), this.heatAggression);
    }
}
