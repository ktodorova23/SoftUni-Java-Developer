package avatar.entities.benders;

public class WaterBender extends BenderImpl {
    private double waterClarity;

    public WaterBender(String name, long power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.waterClarity;
    }

    @Override
    public String toString() {
        return String.format("•Water Bender: %s, Power: %d, Water Clarity: %.2f",
                this.getName(), this.getPower(), this.waterClarity);
    }
}
