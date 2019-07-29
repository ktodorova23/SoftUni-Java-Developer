package com.softuni.xmlprocessing.services;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.ProductsRangeRootDto;
import com.softuni.xmlprocessing.domain.dtos.exportDtos.ProductsSimpleViewDto;
import com.softuni.xmlprocessing.domain.dtos.importDtos.ProductInputDto;
import com.softuni.xmlprocessing.domain.dtos.importDtos.ProductInputRootDto;
import com.softuni.xmlprocessing.domain.entities.Product;
import com.softuni.xmlprocessing.repositories.ProductRepository;
import com.softuni.xmlprocessing.services.base.CategoryService;
import com.softuni.xmlprocessing.services.base.ProductService;
import com.softuni.xmlprocessing.services.base.UserService;
import com.softuni.xmlprocessing.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final static String PRODUCTS_XML_INPUT_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\inputs\\products.xml";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, XMLParser xmlParser) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedProducts() throws JAXBException, FileNotFoundException {
        ProductInputRootDto productInputRootDto = this.xmlParser.parseXml(ProductInputRootDto.class, PRODUCTS_XML_INPUT_FILE_PATH);

        for (ProductInputDto product : productInputRootDto.getProducts()) {
            Product map = this.modelMapper.map(product, Product.class);
            map.setBuyer(this.userService.getRandomBuyer());
            map.setSeller(this.userService.getRandomSeller());
            map.setCategories(this.categoryService.getRandomCategories());
            this.productRepository.saveAndFlush(map);
        }
    }

    @Override
    public ProductsRangeRootDto getAllProductsInPriceRange500To1000() {
        List<Product> allProductsInRange = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        List<ProductsSimpleViewDto> result = new ArrayList<>();

        for (Product product : allProductsInRange) {
            ProductsSimpleViewDto productDto = this.modelMapper.map(product, ProductsSimpleViewDto.class);
            productDto.setSeller(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());

            result.add(productDto);
        }

        ProductsRangeRootDto productsRangeRootDto = new ProductsRangeRootDto();
        productsRangeRootDto.setProducts(result);

        return productsRangeRootDto;
    }
}
