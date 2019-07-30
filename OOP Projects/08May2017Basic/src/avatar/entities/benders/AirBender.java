package avatar.entities.benders;

public class AirBender extends BenderImpl {
    private double aerialIntegrity;

    public AirBender(String name, long power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format("Air Bender: %s, Power: %d, Aerial Integrity: %.2f",
                this.getName(), this.getPower(), this.aerialIntegrity);
    }
}
