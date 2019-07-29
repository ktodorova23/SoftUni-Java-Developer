package com.softuni.xmlprocessing.services.base;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.CategoryRootDto;
import com.softuni.xmlprocessing.domain.entities.Category;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws JAXBException, FileNotFoundException;

    Set<Category> getRandomCategories();

    CategoryRootDto categoriesByProducts();

}
