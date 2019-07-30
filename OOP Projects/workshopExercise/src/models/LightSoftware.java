package models;

public class LightSoftware extends SoftwareImpl {
    private static final String LIGHT_SOFTWARE_TYPE = "LightSoftware";

    public LightSoftware(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
        super.setType(LightSoftware.LIGHT_SOFTWARE_TYPE);
        super.setCapacityConsumption(capacityConsumption + (int) (capacityConsumption * 0.5));
        super.setMemoryConsumption(memoryConsumption - (int) (memoryConsumption * 0.5));
    }
}
