package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.CategorySeedDto;
import com.softuni.demo.domain.dtos.CategorySimpleViewDto;
import com.softuni.demo.domain.entities.Category;
import com.softuni.demo.repositories.CategoryRepository;
import com.softuni.demo.services.base.CategoryService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(ValidatorUtil validatorUtil, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(String path) throws IOException {
        String content = this.fileUtil.fileContent(path);

        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(content, CategorySeedDto[].class);

        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!this.validatorUtil.isValid(categorySeedDto)) {
                this.validatorUtil.violations(categorySeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            Category category = this.modelMapper.map(categorySeedDto, Category.class);

            this.categoryRepository.saveAndFlush(category);
        }
    }

    /* Query 3 - Categories By Products Count */
    @Override
    public Set<CategorySimpleViewDto> categoriesByProducts() {
        List<Category> allCategories = this.categoryRepository.findAllOrOrderByProductsSize();

        Set<CategorySimpleViewDto> categoryDtos = new LinkedHashSet<>();
        for (Category category : allCategories) {
            CategorySimpleViewDto categorySimpleViewDto = this.modelMapper.map(category, CategorySimpleViewDto.class);
            categorySimpleViewDto.setProductsCount(category.getProducts().size());
            categorySimpleViewDto.setAveragePrice(
                    categorySimpleViewDto.getProductsCount() == 0
                    ? 0
                    : category.getProducts()
                            .stream()
                            .mapToDouble(i -> i.getPrice().doubleValue())
                            .average()
                            .getAsDouble());
            categorySimpleViewDto.setTotalRevenue(
                    categorySimpleViewDto.getProductsCount() == 0
                    ? BigDecimal.ZERO
                    : BigDecimal.valueOf(category.getProducts()
                            .stream()
                            .mapToDouble(p -> p.getPrice().doubleValue())
                            .sum()));
            categoryDtos.add(categorySimpleViewDto);
        }
        return categoryDtos;
    }
}
