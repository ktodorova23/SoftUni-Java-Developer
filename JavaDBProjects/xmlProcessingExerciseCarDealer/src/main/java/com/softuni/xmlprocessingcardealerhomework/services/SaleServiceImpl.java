package com.softuni.xmlprocessingcardealerhomework.services;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CarDataDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.SaleDataDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.SaleInformationRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Sale;
import com.softuni.xmlprocessingcardealerhomework.repositories.SaleRepository;
import com.softuni.xmlprocessingcardealerhomework.services.base.CarService;
import com.softuni.xmlprocessingcardealerhomework.services.base.CustomerService;
import com.softuni.xmlprocessingcardealerhomework.services.base.SaleService;
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
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final Random random;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, Random random, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.random = random;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        for (int i = 0; i < 50; i++) {
            Sale sale = new Sale();
            sale.setCar(this.carService.getRandomCar());
            sale.setCustomer(this.customerService.getRandomCustomer());
            sale.setDiscount(sale.getCustomer().getYoungDriver()
                    ? this.getRandomDiscount() + 0.05
                    : this.getRandomDiscount());

            this.saleRepository.saveAndFlush(sale);
        }
    }
    /* Query 6 – Sales with Applied Discount*/
    @Override
    public SaleInformationRootDto getSalesWithInfo() {
        List<Sale> allSales = this.saleRepository.findAll();

        List<SaleDataDto> dtos = new ArrayList<>();

        for (Sale sale : allSales) {
            SaleDataDto dto = this.modelMapper.map(sale, SaleDataDto.class);
            dto.setCar(this.modelMapper.map(sale.getCar(), CarDataDto.class));
            dto.setCustomerName(sale.getCustomer().getName());
            dto.setPrice(sale.getCar().getPrice());
            BigDecimal priceWithDiscount = sale.getCar().getPrice().subtract(
                    sale.getCar().getPrice()
                            .multiply(BigDecimal.valueOf(sale.getDiscount())));

            dto.setPriceWithDiscount(priceWithDiscount);

            dtos.add(dto);
        }

        SaleInformationRootDto saleInformationRootDto = new SaleInformationRootDto();
        saleInformationRootDto.setSales(dtos);

        return saleInformationRootDto;
    }

    private Double getRandomDiscount() {
        List<Double> possibleDiscounts = List.of(0.00, 0.05, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50);

        int index = this.random.nextInt(possibleDiscounts.size());

        return possibleDiscounts.get(index);
    }
}
