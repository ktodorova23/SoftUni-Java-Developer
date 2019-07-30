package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;
import com.softuni.demo.domain.entities.Supplier;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class PartSeedDto implements Serializable {
    @Expose
    @NotNull(message = "A part should have a name!")
    private String name;
    @Expose
    @Min(value = 0, message = "Pricec cannot be negative number!")
    private BigDecimal price;
    @Expose
    @Min(value = 0, message = "Quantity cannot be negative!")
    private int quantity;
    @Expose
    private Supplier supplier;

    public PartSeedDto() {}

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
