package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Set;

public class CarWithPartsDto implements Serializable {
    @Expose
    private CarInformationDto car;
    @Expose
    private Set<PartCommonInfoDto> parts;

    public CarWithPartsDto() {}

    public CarInformationDto getCar() {
        return car;
    }

    public void setCar(CarInformationDto car) {
        this.car = car;
    }

    public Set<PartCommonInfoDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartCommonInfoDto> parts) {
        this.parts = parts;
    }
}
