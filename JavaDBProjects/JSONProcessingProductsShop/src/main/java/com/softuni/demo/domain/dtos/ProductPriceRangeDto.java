package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;
import com.softuni.demo.domain.entities.User;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductPriceRangeDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String seller;

    public ProductPriceRangeDto() {}

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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
