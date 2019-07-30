package com.softuni.xmlprocessingcardealerhomework.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    @OneToOne(targetEntity = Car.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Car car;
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Customer customer;
    @NotNull
    private Double discount;

    public Sale() {}

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
