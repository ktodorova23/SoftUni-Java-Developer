package avatar.entities.monuments;

public class WaterMonument extends MonumentImpl {
    public WaterMonument(String name, long affinity) {
        super(name, affinity);
    }

    @Override
    public String toString() {
        return String.format("Water Monument: %s, Water Affinity: %d",
                super.getName(), super.getAffinity());
    }
}
