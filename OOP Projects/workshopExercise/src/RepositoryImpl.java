import interfaces.Hardware;
import interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {
    private Map<String, Hardware> hardwareComponents;


    public RepositoryImpl() {
        this.hardwareComponents = new HashMap<>();
    }

    @Override
    public void addHardwareComponent(Hardware hardwareComponent) {
        this.hardwareComponents.put(hardwareComponent.getName(), hardwareComponent);
    }
}
