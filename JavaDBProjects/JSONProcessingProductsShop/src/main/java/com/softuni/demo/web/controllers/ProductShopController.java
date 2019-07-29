package com.softuni.demo.web.controllers;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.ProductPriceRangeDto;
import com.softuni.demo.domain.dtos.UserWithSoldProductsDto;
import com.softuni.demo.services.base.CategoryService;
import com.softuni.demo.services.base.ProductService;
import com.softuni.demo.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class ProductShopController implements CommandLineRunner {
    private final static String USER_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingProductsShop\\src\\main\\resources\\json files\\users.json";
    private final static String CATEGORY_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingProductsShop\\src\\main\\resources\\json files\\categories.json";
    private final static String PRODUCTS_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingProductsShop\\src\\main\\resources\\json files\\products.json";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final Gson gson;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, ProductService productService, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws IOException {
        this.seedDatabase();

        /* Query 1 - Products In Range */
//        this.getAndPrintProductsInRange();

        /* Query 2 - Successfully Sold Products */
//        this.getAndPrintInfoAboutSuccessfullySoldProducts();

        /* Query 3 - Categories By Products Count */
//        this.getAndPrintCategoriesByProductsCount();

        /* Query 4 - Users and Products */
//        this.getAndPrintUsersAndProducts();
    }

    private void seedDatabase() throws IOException {
        this.userService.seedUsers(USER_FILE_PATH);
        this.categoryService.seedCategories(CATEGORY_FILE_PATH);
        this.productService.seedProducts(PRODUCTS_FILE_PATH);
        this.userService.seedWithFriends();
    }

    /* Query 1 - Products In Range */
    private void getAndPrintProductsInRange() {
        List<ProductPriceRangeDto> allProductsInPriceRange500To1000 = this.productService.getAllProductsInPriceRange500To1000();
        System.out.println(this.gson.toJson(this.productService.getAllProductsInPriceRange500To1000()));
    }

    /* Query 2 - Successfully Sold Products */
    private void getAndPrintInfoAboutSuccessfullySoldProducts() {
        System.out.println(this.gson.toJson(this.userService.getAllUsersWithSoldProductsWithBuyerName()));
    }

    /* Query 3 - Categories By Products Count */
    private void getAndPrintCategoriesByProductsCount() {
        System.out.println(this.gson.toJson(this.categoryService.categoriesByProducts()));
    }

    /* Query 4 - Users and Products */
    private void getAndPrintUsersAndProducts() {
        System.out.println(this.gson.toJson(this.userService.usersAndProducts()));
    }
}
