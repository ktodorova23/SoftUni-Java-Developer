package models;

import interfaces.Hardware;

import java.util.ArrayList;
import java.util.List;

public class HardwareImpl extends SystemImpl implements Hardware {
    private int maximumCapacity;
    private int maximumMemory;
    private List<SoftwareImpl> softwareUsages;

    public HardwareImpl(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.softwareUsages = new ArrayList<>();
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    @Override
    public void consumeCapacity(int capacity) {
        if (capacity <= this.maximumCapacity) {
            this.maximumCapacity -= capacity;
        }
    }

    @Override
    public void consumeMemory(int memory) {
        if (memory <= this.maximumMemory) {
            this.maximumMemory -= memory;
        }
    }
}
