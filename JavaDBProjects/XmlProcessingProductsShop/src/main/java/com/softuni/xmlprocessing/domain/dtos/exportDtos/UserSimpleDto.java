package com.softuni.xmlprocessing.domain.dtos.exportDtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSimpleDto {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute
    private int age;

    @XmlElement(name = "sold-products")
    private ProductSoldDto soldProducts;

    public UserSimpleDto() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductSoldDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
