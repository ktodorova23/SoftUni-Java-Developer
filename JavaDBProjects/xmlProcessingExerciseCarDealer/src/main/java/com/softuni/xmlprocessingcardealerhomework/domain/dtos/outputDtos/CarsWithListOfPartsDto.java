package com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsWithListOfPartsDto {
    @XmlElement(name = "car")
    private List<CarSimpleDto> cars;

    public CarsWithListOfPartsDto() {}

    public List<CarSimpleDto> getCars() {
        return cars;
    }

    public void setCars(List<CarSimpleDto> cars) {
        this.cars = cars;
    }
}
