package com.softuni.xmlprocessing.services.base;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.ProductsRangeRootDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface ProductService {
    void seedProducts() throws JAXBException, FileNotFoundException;

    /* Query 1 - Products In Range */
    ProductsRangeRootDto getAllProductsInPriceRange500To1000();
}
