package avatar.entities.monuments;

public class FireMonument extends MonumentImpl {
    public FireMonument(String name, long affinity) {
        super(name, affinity);
    }

    @Override
    public String toString() {
        return String.format("Fire Monument: %s, Fire Affinity: %d",
                super.getName(), super.getAffinity());
    }
}
