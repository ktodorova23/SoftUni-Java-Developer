package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.SaleDiscountsDto;

import java.util.List;

public interface SaleService {
    void seedSales();

    /* Query 6 – Sales with Applied Discount */
    List<SaleDiscountsDto> getSalesWithInfo();
}
