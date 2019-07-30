package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;
import com.softuni.demo.domain.entities.Part;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

public class CarSeedDto implements Serializable {
    @Expose
    @NotNull(message = "Make of a car cannot be null!")
    private String make;
    @Expose
    @NotNull(message = "A car model cannot be null!")
    private String model;
    @Expose
    @NotNull(message = "Travelled distance cannot be null!")
    private long travelledDistance;
    @Expose
    private Set<Part> parts;

    public CarSeedDto() {}

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
