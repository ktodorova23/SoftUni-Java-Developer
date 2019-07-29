package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductSimpleViewDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductSimpleViewDto() {}

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
