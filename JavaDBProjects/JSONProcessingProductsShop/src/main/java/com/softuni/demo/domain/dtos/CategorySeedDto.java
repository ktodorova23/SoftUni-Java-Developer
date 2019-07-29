package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CategorySeedDto implements Serializable {
    @Expose
    @Size(min = 3, max = 15, message = "Category name should be between 3 and 15 symbols long!")
    @NotNull(message = "Category name cannot be null!")
    private String name;

    public CategorySeedDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
