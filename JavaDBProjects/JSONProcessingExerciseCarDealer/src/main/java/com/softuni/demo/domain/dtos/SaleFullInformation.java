package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SaleFullInformation implements Serializable {
    @Expose
    private double discount;
    @Expose
    private CarInformationDto car;

    public SaleFullInformation() {}

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public CarInformationDto getCar() {
        return car;
    }

    public void setCar(CarInformationDto car) {
        this.car = car;
    }
}
