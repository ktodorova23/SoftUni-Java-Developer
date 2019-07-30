package com.softuni.xmlprocessingcardealerhomework.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    @Column(name = "travelled_distance")
    private Long travelledDistance;

    @ManyToMany(targetEntity = Part.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    private Set<Part> parts;

    @OneToOne(targetEntity = Sale.class, mappedBy = "car")
    private Sale sale;

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

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        BigDecimal result = BigDecimal.ZERO;

        for (Part part : parts) {
            result = result.add(part.getPrice());
        }

        return result;
    }
}
