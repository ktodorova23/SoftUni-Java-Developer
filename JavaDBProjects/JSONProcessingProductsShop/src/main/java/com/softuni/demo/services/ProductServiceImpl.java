package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.ProductPriceRangeDto;
import com.softuni.demo.domain.dtos.ProductSeedDto;
import com.softuni.demo.domain.entities.Category;
import com.softuni.demo.domain.entities.Product;
import com.softuni.demo.domain.entities.User;
import com.softuni.demo.repositories.CategoryRepository;
import com.softuni.demo.repositories.ProductRepository;
import com.softuni.demo.repositories.UserRepository;
import com.softuni.demo.services.base.ProductService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(FileUtil fileUtil, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper, ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedProducts(String path) throws IOException {
        String content = this.fileUtil.fileContent(path);

        ProductSeedDto[] productSeedDtos = this.gson.fromJson(content, ProductSeedDto[].class);

        for (ProductSeedDto productSeedDto : productSeedDtos) {
            productSeedDto.setBuyer(this.getRandomBuyer());
            productSeedDto.setSeller(this.getRandomSeller());
            productSeedDto.setCategories(this.getRandomCategories());
            if (!this.validatorUtil.isValid(productSeedDto)) {
                this.validatorUtil.violations(productSeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            Product product = this.modelMapper.map(productSeedDto, Product.class);

            this.productRepository.saveAndFlush(product);
        }

    }

    private User getRandomBuyer() {
        Random random = new Random();

        int userId = random.nextInt((int) this.userRepository.count() - 1) + 1;

        if (userId % 3 == 0) {
            return null;
        }

        return this.userRepository.findById(userId).get();
    }

    private User getRandomSeller() {
        Random random = new Random();

        int userId = random.nextInt((int) this.userRepository.count() - 1) + 1;

        return this.userRepository.findById(userId).get();
    }


    private Category getRandomCategory() {
        Random random = new Random();

        int categoryId = random.nextInt((int) this.categoryRepository.count() - 1) + 1;

        return this.categoryRepository.findById(categoryId).get();
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        Random random = new Random();
        int countCategories = random.nextInt((int) this.categoryRepository.count() - 1) + 1;

        for (int i = 0; i < countCategories; i++) {
            categories.add(this.getRandomCategory());
        }

        return categories;
    }

    /* Query 1 - Products In Range */
    @Override
    public List<ProductPriceRangeDto> getAllProductsInPriceRange500To1000() {
        List<Product> allByPriceBetween = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        List<ProductPriceRangeDto> allProductsPriceRangeDtos = new ArrayList<>();

        for (Product product : allByPriceBetween) {
            ProductPriceRangeDto productPriceRangeDto = this.modelMapper.map(product, ProductPriceRangeDto.class);
            productPriceRangeDto.setSeller(String.format("%s %s",
                    product.getSeller().getFirstName(),
                    product.getSeller().getLastName()));
            allProductsPriceRangeDtos.add(productPriceRangeDto);
        }

        return allProductsPriceRangeDtos;
    }
}
