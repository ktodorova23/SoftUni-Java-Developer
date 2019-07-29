package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.CategorySimpleViewDto;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories(String path) throws IOException;

    /* Query 3 - Categories By Products Count */
    Set<CategorySimpleViewDto> categoriesByProducts();

}
