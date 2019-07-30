package com.softuni.xmlprocessingcardealerhomework.services.base;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CustomerOrderedRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CustomerSalesDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Customer;

import javax.xml.bind.JAXBException;

public interface CustomerService {
    void seedCustomers() throws JAXBException;

    Customer getRandomCustomer();

    /* Query 1 – Ordered Customers */
    CustomerOrderedRootDto orderedCustomers();

    /* Query 5 – Total Sales by Customer */
    CustomerSalesDto getAllWithAtLeastOneCarBought();
}
