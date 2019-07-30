package models;

public class PowerHardware extends HardwareImpl {
    private static final String POWER_HARDWARE_TYPE = "PowerHardware";

    public PowerHardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
        super.setType(POWER_HARDWARE_TYPE);
        super.setMaximumCapacity(maximumCapacity - (int) (maximumCapacity * 0.75));
        super.setMaximumMemory(maximumMemory = maximumMemory + (int) (maximumMemory * 0.75));
    }
}
