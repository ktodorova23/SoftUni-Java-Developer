package com.softuni.xmlprocessingcardealerhomework.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    @NotNull
    private String name;
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @NotNull
    @Column(name = "is_young_driver")
    private Boolean isYoungDriver;

    @OneToMany(targetEntity = Sale.class, mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sale> sales;

    public Customer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public BigDecimal getMoneySpent() {
        BigDecimal result = BigDecimal.ZERO;

        for (Sale sale : sales) {
            result = result.add(sale.getCar().getPrice());
        }
        return result;
    }
}
