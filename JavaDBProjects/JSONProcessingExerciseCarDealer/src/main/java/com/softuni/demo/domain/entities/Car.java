package com.softuni.demo.domain.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car  extends BaseEntity{
    private String make;
    private String model;
    @Column(name = "travelled_distance")
    private long travelledDistance;
    @ManyToMany(targetEntity = Part.class)
    @JoinTable(
            name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Part> parts;

    public Car() {}

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

    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal(0);
        for (Part part : parts) {
            price = price.add(part.getPrice());
        }

        return price;
    }
}
