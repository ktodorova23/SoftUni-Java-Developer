package com.softuni.demo.domain.dtos;

import java.math.BigDecimal;

public class GameCommonView {
    private String title;
    private BigDecimal price;

    public GameCommonView() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
