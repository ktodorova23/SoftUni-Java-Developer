package com.softuni.demo.web.controllers;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.CustomerFullInformation;
import com.softuni.demo.services.base.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Set;

@Controller
public class CarDealersController implements CommandLineRunner {
    private final static String SUPPLIERS_JSON_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingExerciseCarDealer\\src\\main\\resources\\json files\\suppliers.json";
    private final static String PARTS_JSON_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingExerciseCarDealer\\src\\main\\resources\\json files\\parts.json";
    private final static String CARS_JSON_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingExerciseCarDealer\\src\\main\\resources\\json files\\cars.json";
    private final static String CUSTOMERS_JSON_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\JSONProcessingExerciseCarDealer\\src\\main\\resources\\json files\\customers.json";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;

    @Autowired
    public CarDealersController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws IOException {
//        this.seedDatabase();

        /* Query 1 – Ordered Customers */
//        this.getAndPrintOrderedCustomers();

        /* Query 2 – Cars from make Toyota */
//        this.getAndPrintCarsFromMakeToyotaOrdered();

        /* Query 3 – Local Suppliers */
//        this.getAndPrintLocalSuppliers();

        /* Query 4 – Cars with Their List of Parts */
//        this.getAndPrintInfoForCarsWithTheirParts();

        /* Query 5 – Total Sales by Customer */
//        this.getAndPrintTotalSalesByCustomerOrdered();

        /* Query 6 – Sales with Applied Discount */
//        this.getAndPrintSalesWithAppliedDiscount();
    }

    private void seedDatabase() throws IOException {
        this.supplierService.seedSuppliers(SUPPLIERS_JSON_FILE_PATH);
        this.partService.seedParts(PARTS_JSON_FILE_PATH);
        this.carService.seedCars(CARS_JSON_FILE_PATH);
        this.customerService.seedCustomers(CUSTOMERS_JSON_FILE_PATH);
        this.saleService.seedSales();
    }

    /* Query 1 – Ordered Customers */
    private void getAndPrintOrderedCustomers() {
        Set<CustomerFullInformation> customerFullInformations = this.customerService.orderedCustomers();
        System.out.println(this.gson.toJson(customerFullInformations));
    }

    /* Query 2 – Cars from make Toyota */
    private void getAndPrintCarsFromMakeToyotaOrdered() {
        System.out.println(this.gson.toJson(this.carService.carsFromMakeToyotaOrderedByModelAndTravelledDistance()));
    }

    /* Query 3 – Local Suppliers */
    private void getAndPrintLocalSuppliers() {
        System.out.println(this.gson.toJson(this.supplierService.getLocalSuppliers()));
    }

    /* Query 4 – Cars with Their List of Parts */
    private void getAndPrintInfoForCarsWithTheirParts() {
        System.out.println(this.gson.toJson(this.carService.getAllCarsWithParts()));
    }

    /* Query 5 – Total Sales by Customer */
    private void getAndPrintTotalSalesByCustomerOrdered() {
        System.out.println(this.gson.toJson(this.customerService.getAllWithAtLeastOneCarBought()));
    }

    /* Query 6 – Sales with Applied Discount */
    private void getAndPrintSalesWithAppliedDiscount() {
        System.out.println(this.gson.toJson(this.saleService.getSalesWithInfo()));
    }
}
