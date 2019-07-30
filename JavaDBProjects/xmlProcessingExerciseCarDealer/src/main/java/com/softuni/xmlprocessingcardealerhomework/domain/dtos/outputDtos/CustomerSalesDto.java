package com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSalesDto {
    @XmlElement(name = "customer")
    private List<CustomersDataDto> customers;

    public CustomerSalesDto() {}

    public List<CustomersDataDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomersDataDto> customers) {
        this.customers = customers;
    }
}
