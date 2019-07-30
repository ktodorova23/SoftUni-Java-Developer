package models;

public class ExpressSoftware extends SoftwareImpl {
    private static final String EXPRESS_SOFTWARE_TYPE = "ExpressSoftware";

    public ExpressSoftware(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
        super.setType(ExpressSoftware.EXPRESS_SOFTWARE_TYPE);
        super.setMemoryConsumption(memoryConsumption * 2);
    }
}
