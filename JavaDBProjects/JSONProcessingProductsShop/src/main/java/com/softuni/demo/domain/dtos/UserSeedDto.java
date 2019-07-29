package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserSeedDto implements Serializable {
    @Expose
    private String firstName;
    @Expose
    @Size(min = 3, message = "Last name should be at least 3 symbols long!")
    @NotNull
    private String lastName;
    @Expose
    @Min(value = 0, message = "Age cannot be negative!")
    private int age;

    public UserSeedDto() {}

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
}
