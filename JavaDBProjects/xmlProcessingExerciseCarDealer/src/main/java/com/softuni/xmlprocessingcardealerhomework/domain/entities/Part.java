package com.softuni.xmlprocessingcardealerhomework.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;

    @ManyToOne(targetEntity = Supplier.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Supplier supplier;

    @ManyToMany(targetEntity = Car.class, mappedBy = "parts", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Car> cars;

    public Part() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
