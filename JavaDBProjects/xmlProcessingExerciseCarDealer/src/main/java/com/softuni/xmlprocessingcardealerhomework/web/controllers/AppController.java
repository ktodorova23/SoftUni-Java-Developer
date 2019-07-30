package com.softuni.xmlprocessingcardealerhomework.web.controllers;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.*;
import com.softuni.xmlprocessingcardealerhomework.services.base.*;
import com.softuni.xmlprocessingcardealerhomework.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;

@Controller
public class AppController implements CommandLineRunner {
    private final static String ORDERED_CUSTOMERS_OUTPUT_XML_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\outputs\\ordered-customers.xml";
    private final static String CARS_FROM_MAKE_TOYOTA_OUTPUT_XML_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\outputs\\cars-from-make-toyota.xml";
    private final static String LOCAL_SUPPLIERS_OUTPUT_XML_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\outputs\\local-suppliers.xml";
    private final static String CARS_WITH_THEIR_LIST_OF_PARTS_OUTPUT_XML_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\outputs\\cars-with-their-list-of-parts.xml";
    private final static String TOTAL_SALES_BY_CUSTOMER_OUTPUT_XML_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\outputs\\total-sales-by-customer.xml";
    private final static String SALES_WITH_APPLIED_DISCOUNT_OUTPUT_XML_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\outputs\\sales-with-applied-discount.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final XmlParser xmlParser;

    @Autowired
    public AppController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
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

    private void seedDatabase() throws JAXBException {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
        this.customerService.seedCustomers();
        this.saleService.seedSales();
    }

    /* Query 1 – Ordered Customers */
    private void getAndPrintOrderedCustomers() throws JAXBException {
        CustomerOrderedRootDto customerOrderedRootDto = this.customerService.orderedCustomers();
        this.xmlParser.exportToXml(customerOrderedRootDto, CustomerOrderedRootDto.class, ORDERED_CUSTOMERS_OUTPUT_XML_PATH);
    }

    /* Query 2 – Cars from make Toyota */
    private void getAndPrintCarsFromMakeToyotaOrdered() throws JAXBException {
        CarsFromMakeToyotaRootDto carsFromMakeToyotaRootDto = this.carService.carsFromMakeToyotaOrderedByModelAndTravelledDistance();
        this.xmlParser.exportToXml(carsFromMakeToyotaRootDto, CarsFromMakeToyotaRootDto.class, CARS_FROM_MAKE_TOYOTA_OUTPUT_XML_PATH);
    }

    /* Query 3 – Local Suppliers */
    private void getAndPrintLocalSuppliers() throws JAXBException {
        LocalSupplierRootDto localSuppliers = this.supplierService.getLocalSuppliers();
        this.xmlParser.exportToXml(localSuppliers, LocalSupplierRootDto.class, LOCAL_SUPPLIERS_OUTPUT_XML_PATH);
    }

    /* Query 4 – Cars with Their List of Parts */
    private void getAndPrintInfoForCarsWithTheirParts() throws JAXBException {
        CarsWithListOfPartsDto allCarsWithParts = this.carService.getAllCarsWithParts();
        this.xmlParser.exportToXml(allCarsWithParts, CarsWithListOfPartsDto.class, CARS_WITH_THEIR_LIST_OF_PARTS_OUTPUT_XML_PATH);
    }

    /* Query 5 – Total Sales by Customer */
    private void getAndPrintTotalSalesByCustomerOrdered() throws JAXBException {
        CustomerSalesDto allWithAtLeastOneCarBought = this.customerService.getAllWithAtLeastOneCarBought();
        this.xmlParser.exportToXml(allWithAtLeastOneCarBought, CustomerSalesDto.class, TOTAL_SALES_BY_CUSTOMER_OUTPUT_XML_PATH);
    }

    /* Query 6 – Sales with Applied Discount */
    private void getAndPrintSalesWithAppliedDiscount() throws JAXBException {
        SaleInformationRootDto salesWithInfo = this.saleService.getSalesWithInfo();
        this.xmlParser.exportToXml(salesWithInfo, SaleInformationRootDto.class, SALES_WITH_APPLIED_DISCOUNT_OUTPUT_XML_PATH);
    }
}
