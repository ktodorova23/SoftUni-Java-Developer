package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CustomerSeedDto {
    @Expose
    @NotNull(message = "Customer's name cannot be null!")
    private String name;
    @Expose
    @NotNull(message = "A birth date should be present for each customer!")
    private String birthDate;
    @Expose
    @NotNull(message = "A customer should be marked as young driver or not!")
    private boolean isYoungDriver;

    public CustomerSeedDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
