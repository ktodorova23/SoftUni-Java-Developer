package com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleInformationRootDto {
    @XmlElement(name = "sale")
    private List<SaleDataDto> sales;

    public SaleInformationRootDto() {}

    public List<SaleDataDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleDataDto> sales) {
        this.sales = sales;
    }
}
