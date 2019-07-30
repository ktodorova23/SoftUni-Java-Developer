package models;

public class HeavyHardware extends HardwareImpl {
    private static final String HEAVY_HARDWARE_TYPE = "HeavyHardware";

    public HeavyHardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
        super.setType(HeavyHardware.HEAVY_HARDWARE_TYPE);
        super.setMaximumCapacity(maximumCapacity * 2);
        super.setMaximumMemory(maximumMemory - (int) (maximumMemory * 0.25));
    }
}
