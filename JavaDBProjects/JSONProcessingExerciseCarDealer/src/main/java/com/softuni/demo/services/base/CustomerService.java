package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.CustomerFullInformation;
import com.softuni.demo.domain.dtos.CustomerSalesDto;

import java.io.IOException;
import java.util.Set;

public interface CustomerService {
    void seedCustomers(String path) throws IOException;

    /* Query 1 – Ordered Customers */
    Set<CustomerFullInformation> orderedCustomers();

    /* Query 5 – Total Sales by Customer */
    Set<CustomerSalesDto> getAllWithAtLeastOneCarBought();
}
