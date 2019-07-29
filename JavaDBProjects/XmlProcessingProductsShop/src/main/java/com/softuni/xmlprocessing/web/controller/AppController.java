package com.softuni.xmlprocessing.web.controller;

import com.softuni.xmlprocessing.domain.dtos.exportDtos.CategoryRootDto;
import com.softuni.xmlprocessing.domain.dtos.exportDtos.ProductsRangeRootDto;
import com.softuni.xmlprocessing.domain.dtos.exportDtos.UserRootDto;
import com.softuni.xmlprocessing.domain.dtos.exportDtos.UsersAndProductsRootDto;
import com.softuni.xmlprocessing.services.base.CategoryService;
import com.softuni.xmlprocessing.services.base.ProductService;
import com.softuni.xmlprocessing.services.base.UserService;
import com.softuni.xmlprocessing.utils.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Controller
public class AppController implements CommandLineRunner {
    private final static String PRODUCTS_IN_RANGE_QUERY_RESULT_XML_FILE = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\outputs\\products-in-range.xml";
    private final static String SUCCESSFULLY_SOLD_PRODUCTS_QUERY_RESULT_XML_FILE = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\outputs\\successfully-sold-products.xml";
    private final static String CATEGORIES_BY_PRODUCTS_COUNT_QUERY_RESULT_XML_FILE = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\outputs\\categories-by-products-count.xml";
    private final static String USERS_AND_PRODUCTS_QUERY_RESULT_XML_FILE = "E:\\Java\\DB Projects\\JavaDB\\XmlProcessingProductsShop\\src\\main\\resources\\xml\\outputs\\users-and-products.xml";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final XMLParser xmlParser;

    @Autowired
    public AppController(UserService userService, CategoryService categoryService, ProductService productService, XMLParser xmlParser) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedDatabase();

        /* Query 1 - Products In Range */
        this.getAndPrintProductsInRange();

        /* Query 2 - Successfully Sold Products */
        this.getAndPrintInfoAboutSuccessfullySoldProducts();

        /* Query 3 - Categories By Products Count */
        this.getAndPrintCategoriesByProductsCount();

        /* Query 4 - Users and Products */
        this.getAndPrintUsersAndProducts();
    }

    private void seedDatabase() throws JAXBException, FileNotFoundException {
        this.userService.seedUsers();
        this.categoryService.seedCategories();
        this.productService.seedProducts();
        this.userService.seedFriends();
    }

    /* Query 1 - Products In Range */
    private void getAndPrintProductsInRange() throws JAXBException {
        ProductsRangeRootDto products = this.productService.getAllProductsInPriceRange500To1000();
        this.xmlParser.exportToXml(products, ProductsRangeRootDto.class, PRODUCTS_IN_RANGE_QUERY_RESULT_XML_FILE);
    }

    /* Query 2 - Successfully Sold Products */
    private void getAndPrintInfoAboutSuccessfullySoldProducts() throws JAXBException {
        UserRootDto users = this.userService.getAllUsersWithSoldProductsWithBuyerName();
        this.xmlParser.exportToXml(users, UserRootDto.class, SUCCESSFULLY_SOLD_PRODUCTS_QUERY_RESULT_XML_FILE);
    }

    /* Query 3 - Categories By Products Count */
    private void getAndPrintCategoriesByProductsCount() throws JAXBException {
        CategoryRootDto categoryRootDto = this.categoryService.categoriesByProducts();
        this.xmlParser.exportToXml(categoryRootDto, CategoryRootDto.class, CATEGORIES_BY_PRODUCTS_COUNT_QUERY_RESULT_XML_FILE);
    }

    /* Query 4 - Users and Products */
    private void getAndPrintUsersAndProducts() throws JAXBException {
        UsersAndProductsRootDto usersAndProductsRootDto = this.userService.usersAndProducts();
        this.xmlParser.exportToXml(usersAndProductsRootDto, UsersAndProductsRootDto.class, USERS_AND_PRODUCTS_QUERY_RESULT_XML_FILE);
    }
}
