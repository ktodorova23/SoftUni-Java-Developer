package com.softuni.xmlprocessing.domain.dtos.exportDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsRangeRootDto {

    @XmlElement(name = "product")
    private List<ProductsSimpleViewDto> products;

    public ProductsRangeRootDto() {}

    public List<ProductsSimpleViewDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsSimpleViewDto> products) {
        this.products = products;
    }
}
