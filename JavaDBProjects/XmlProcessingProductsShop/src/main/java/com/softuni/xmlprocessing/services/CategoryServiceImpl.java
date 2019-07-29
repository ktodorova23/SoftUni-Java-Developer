package com.softuni.xmlprocessing.services;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.CategoryDto;
import com.softuni.xmlprocessing.domain.dtos.exportDtos.CategoryRootDto;
import com.softuni.xmlprocessing.domain.dtos.importDtos.CategoryInputDto;
import com.softuni.xmlprocessing.domain.dtos.importDtos.CategoryInputRootDto;
import com.softuni.xmlprocessing.domain.entities.Category;
import com.softuni.xmlprocessing.domain.entities.Product;
import com.softuni.xmlprocessing.repositories.CategoryRepository;
import com.softuni.xmlprocessing.services.base.CategoryService;
import com.softuni.xmlprocessing.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final static String CATEGORY_XML_INPUT_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\inputs\\categories.xml";

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, XMLParser xmlParser) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCategories() throws JAXBException, FileNotFoundException {
        CategoryInputRootDto categoryInputRootDto = this.xmlParser.parseXml(CategoryInputRootDto.class, CATEGORY_XML_INPUT_FILE_PATH);

        for (CategoryInputDto category : categoryInputRootDto.getCategories()) {
            Category entity = this.modelMapper.map(category, Category.class);

            this.categoryRepository.saveAndFlush(entity);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        Random random = new Random();
        int countCategories = random.nextInt((int) this.categoryRepository.count() - 1) + 1;

        for (int i = 0; i < countCategories; i++) {
            int categoryId = random.nextInt((int) this.categoryRepository.count() - 1) + 1;
            categories.add(this.categoryRepository.findById(categoryId).get());
        }

        return categories;
    }

    /* Query 3 - Categories By Products Count */
    @Override
    public CategoryRootDto categoriesByProducts() {
        List<Category> categories = this.categoryRepository.findAllOrderByProductsSize();

        List<CategoryDto> result = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
            categoryDto.setProductsCount(category.getProducts().size());

            categoryDto.setAveragePrice(
                    categoryDto.getProductsCount() == 0
                    ? 0
                    : category.getProducts().stream()
                            .mapToDouble(p -> p.getPrice().doubleValue())
                            .average()
                            .getAsDouble());

            categoryDto.setTotalRevenue(
                    categoryDto.getProductsCount() == 0
                    ? BigDecimal.ZERO
                    : BigDecimal.valueOf(
                            category.getProducts()
                                    .stream()
                                    .mapToDouble(p -> p.getPrice().doubleValue())
                                    .sum())
            );

            result.add(categoryDto);
        }

        CategoryRootDto categoryRootDto = new CategoryRootDto();
        categoryRootDto.setCategories(result);

        return categoryRootDto;
    }
}
