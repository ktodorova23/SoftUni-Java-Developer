package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;
import com.softuni.demo.domain.entities.Category;
import com.softuni.demo.domain.entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class ProductSeedDto implements Serializable {
    @Expose
    @Size(min = 3, message = "Name cannot be shorter than 3 symbols!")
    @NotNull(message = "Name cannot be null!")
    private String name;
    @Expose
    @NotNull(message = "Price cannot be null!")
    private BigDecimal price;
    private User buyer;
    @NotNull(message = "Product should have a seller defined!")
    private User seller;
    @NotNull(message = "Product must have at least one category defined!")
    private Set<Category> categories;

    public ProductSeedDto() {}

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

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
