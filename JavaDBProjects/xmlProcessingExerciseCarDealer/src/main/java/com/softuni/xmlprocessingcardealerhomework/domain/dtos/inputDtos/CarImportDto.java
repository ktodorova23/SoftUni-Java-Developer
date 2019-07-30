package com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDto {
    @XmlElement
    private String make;
    @XmlElement
    private String model;
    @XmlElement(name = "travelled-distance")
    private Long travelledDistance;

    @XmlTransient
    private Set<PartImportDto> parts;

    public CarImportDto() {}

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

    public Set<PartImportDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartImportDto> parts) {
        this.parts = parts;
    }
}
