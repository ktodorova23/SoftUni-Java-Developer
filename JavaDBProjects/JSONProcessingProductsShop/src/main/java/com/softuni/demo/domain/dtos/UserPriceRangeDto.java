package com.softuni.demo.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class UserPriceRangeDto implements Serializable {
    @Expose
    private String seller;

    public UserPriceRangeDto() {}


    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
