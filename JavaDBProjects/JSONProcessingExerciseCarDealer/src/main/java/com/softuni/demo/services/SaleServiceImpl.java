package com.softuni.demo.services;

import com.softuni.demo.domain.dtos.CarInformationDto;
import com.softuni.demo.domain.dtos.SaleDiscountsDto;
import com.softuni.demo.domain.entities.Car;
import com.softuni.demo.domain.entities.Customer;
import com.softuni.demo.domain.entities.Sale;
import com.softuni.demo.repositories.CarRepository;
import com.softuni.demo.repositories.CustomerRepository;
import com.softuni.demo.repositories.SaleRepository;
import com.softuni.demo.services.base.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        Random random = new Random();

        int countSales = random.nextInt(300);

        List<Sale> sales = new ArrayList<>();
        for (int i = 0; i < countSales; i++) {
            Sale sale = new Sale();
            sale.setCar(this.getRandomCar());
            sale.setCustomer(this.getRandomCustomer());
            double discount = this.getRandomDiscount();
            if (sale.getCustomer().isYoungDriver()) {
                discount += 0.05;
            }
            sale.setDiscount(discount);

            sales.add(sale);
        }
        this.saleRepository.saveAll(sales);
    }

    private double getRandomDiscount() {
        List<Double> discounts = List.of(0.00, 0.05, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50);

        Random random = new Random();

        int index = random.nextInt(discounts.size());

        return discounts.get(index);
    }

    private Customer getRandomCustomer() {
        Random random = new Random();

        int id = random.nextInt((int) (this.customerRepository.count())) + 1;
        return this.customerRepository.getOne(id);
    }

    private Car getRandomCar() {
        Random random = new Random();

        int id = random.nextInt((int) (this.carRepository.count())) + 1;
        return this.carRepository.getOne(id);
    }

    /* Query 6 – Sales with Applied Discount */
    @Override
    public List<SaleDiscountsDto> getSalesWithInfo() {
        List<Sale> allSales = this.saleRepository.findAll();

        List<SaleDiscountsDto> dtos = new ArrayList<>();

        for (Sale sale : allSales) {
            SaleDiscountsDto mappedSale = this.modelMapper.map(sale, SaleDiscountsDto.class);

            mappedSale.setCar(this.modelMapper.map(sale.getCar(), CarInformationDto.class));
            mappedSale.setCustomerName(sale.getCustomer().getName());
            mappedSale.setPrice(sale.getCar().getPrice());
            if (mappedSale.getDiscount() != 0.0) {
                BigDecimal discountPrice = mappedSale.getPrice()
                        .subtract(
                                mappedSale.getPrice()
                                        .multiply(BigDecimal.valueOf(mappedSale.getDiscount()))
                        );
                mappedSale.setPriceWithDiscount(discountPrice);
            } else {
                mappedSale.setPriceWithDiscount(mappedSale.getPrice());
            }

            dtos.add(mappedSale);
        }
        return dtos;
    }
}
