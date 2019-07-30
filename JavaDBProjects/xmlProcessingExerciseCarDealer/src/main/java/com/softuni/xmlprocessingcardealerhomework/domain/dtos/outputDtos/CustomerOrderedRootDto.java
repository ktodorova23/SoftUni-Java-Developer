package com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerOrderedRootDto {
    @XmlElement(name = "customer")
    private List<CustomerOrderedDto> customers;

    public CustomerOrderedRootDto() {}

    public List<CustomerOrderedDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerOrderedDto> customers) {
        this.customers = customers;
    }
}
