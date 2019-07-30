package avatar.entities.monuments;

public class AirMonument extends MonumentImpl {
    public AirMonument(String name, long affinity) {
        super(name, affinity);
    }

    @Override
    public String toString() {
        return String.format("Air Monument: %s, Air Affinity: %d",
                super.getName(), super.getAffinity());
    }
}
