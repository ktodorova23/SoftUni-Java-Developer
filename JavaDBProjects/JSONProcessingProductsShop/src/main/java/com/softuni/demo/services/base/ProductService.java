package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.ProductPriceRangeDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void seedProducts(String path) throws IOException;

    /* Query 1 - Products In Range */
    List<ProductPriceRangeDto> getAllProductsInPriceRange500To1000();
}
