package avatar.entities.monuments;

public class EarthMonument extends MonumentImpl {
    public EarthMonument(String name, long affinity) {
        super(name, affinity);
    }

    @Override
    public String toString() {
        return String.format("Earth Monument: %s, Earth Affinity: %d",
                super.getName(), super.getAffinity());
    }
}
