package com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartImportDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;
    @XmlAttribute
    private Integer quantity;
    @XmlTransient
    private SupplierImportDto supplier;

    public PartImportDto() {}

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

    public SupplierImportDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierImportDto supplier) {
        this.supplier = supplier;
    }
}
