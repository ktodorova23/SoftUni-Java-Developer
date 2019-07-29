package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Set;

public class UserSimpleViewDto implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private ProductsForUserDto soldProducts;

    public UserSimpleViewDto() {}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductsForUserDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsForUserDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
