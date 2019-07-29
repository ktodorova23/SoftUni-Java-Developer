package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class UserWithSoldProductsDto implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductSoldWithBuyerNotNull> soldProducts;

    public UserWithSoldProductsDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductSoldWithBuyerNotNull> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductSoldWithBuyerNotNull> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
