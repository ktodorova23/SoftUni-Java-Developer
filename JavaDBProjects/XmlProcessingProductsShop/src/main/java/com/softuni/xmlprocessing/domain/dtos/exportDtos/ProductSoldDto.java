package com.softuni.xmlprocessing.domain.dtos.exportDtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldDto {
    @XmlAttribute(name = "count")
    private int countProducts;

    @XmlElement(name = "product")
    private List<ProductSimpleDto> products;

    public ProductSoldDto() {}

    public int getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(int countProducts) {
        this.countProducts = countProducts;
    }

    public List<ProductSimpleDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSimpleDto> products) {
        this.products = products;
    }
}
