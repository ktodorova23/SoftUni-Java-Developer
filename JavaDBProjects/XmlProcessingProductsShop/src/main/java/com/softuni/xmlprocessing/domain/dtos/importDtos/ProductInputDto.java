package com.softuni.xmlprocessing.domain.dtos.importDtos;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Set;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInputDto {

    @XmlElement
    private String name;

    @XmlElement
    private BigDecimal price;

    public ProductInputDto() {}

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
}
