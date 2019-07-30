package avatar.entities.benders;

public class EarthBender extends BenderImpl {
    private double groundSaturation;

    public EarthBender(String name, long power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("Earth Bender: %s, Power: %d, Ground Saturation: %.2f",
                this.getName(), this.getPower(), this.groundSaturation);
    }
}
