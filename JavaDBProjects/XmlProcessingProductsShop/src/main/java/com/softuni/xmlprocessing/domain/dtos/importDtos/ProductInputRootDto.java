package com.softuni.xmlprocessing.domain.dtos.importDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInputRootDto {

    @XmlElement(name = "product")
    private List<ProductInputDto> products;

    public ProductInputRootDto() {}

    public List<ProductInputDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInputDto> products) {
        this.products = products;
    }
}
