package com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsFromMakeToyotaRootDto {
    @XmlElement(name = "car")
    private List<CarsFromMakeToyotaDto> cars;

    public CarsFromMakeToyotaRootDto() {}


    public List<CarsFromMakeToyotaDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsFromMakeToyotaDto> cars) {
        this.cars = cars;
    }
}
