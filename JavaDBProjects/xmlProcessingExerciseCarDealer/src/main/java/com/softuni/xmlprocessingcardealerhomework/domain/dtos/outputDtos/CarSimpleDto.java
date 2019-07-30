package com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos;

import javax.xml.bind.annotation.*;
import java.util.Set;
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarSimpleDto {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartSimpleDto> parts;

    public CarSimpleDto() {}

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

    public Set<PartSimpleDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartSimpleDto> parts) {
        this.parts = parts;
    }
}
