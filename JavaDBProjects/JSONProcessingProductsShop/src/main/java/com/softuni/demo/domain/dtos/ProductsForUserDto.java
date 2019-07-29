package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class ProductsForUserDto {
    @Expose
    private int count;
    @Expose
    private Set<ProductSimpleViewDto> products;

    public ProductsForUserDto() {}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<ProductSimpleViewDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductSimpleViewDto> products) {
        this.products = products;
    }
}
