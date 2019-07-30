package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.*;
import com.softuni.demo.domain.entities.Customer;
import com.softuni.demo.repositories.CustomerRepository;
import com.softuni.demo.services.base.CustomerService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final FileUtil fileUtil;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(FileUtil fileUtil, ValidatorUtil validatorUtil, Gson gson, ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.fileUtil = fileUtil;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedCustomers(String path) throws IOException {
        String content = this.fileUtil.fileContent(path);

        CustomerSeedDto[] customerSeedDtos = this.gson.fromJson(content, CustomerSeedDto[].class);

        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {
            if (!this.validatorUtil.isValid(customerSeedDto)) {
                this.validatorUtil.validate(customerSeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }
            Customer customer = this.modelMapper.map(customerSeedDto, Customer.class);
            customer.setBirthDate(LocalDateTime.parse(customerSeedDto.getBirthDate()));
            this.customerRepository.saveAndFlush(customer);
        }
    }

    /* Query 1 – Ordered Customers */
    @Override
    public Set<CustomerFullInformation> orderedCustomers() {
        Set<Customer> allCustomers = this.customerRepository.findAllOrderedByBirthDate();

        Set<CustomerFullInformation> customers = new LinkedHashSet<>();

        for (Customer customer : allCustomers) {
            CustomerFullInformation dto = this.modelMapper.map(customer, CustomerFullInformation.class);
            dto.setBirthDate(String.valueOf(customer.getBirthDate()));
            Set<SaleFullInformation> allSalesInfo = null;
            if (customer.getSales().size() > 0) {
                allSalesInfo = customer.getSales()
                        .stream()
                        .map(s -> {
                            CarInformationDto mappedCar = this.modelMapper.map(s.getCar(), CarInformationDto.class);
                            SaleFullInformation mappedSale = this.modelMapper.map(s, SaleFullInformation.class);
                            mappedSale.setCar(mappedCar);
                            return mappedSale;
                        })
                        .collect(Collectors.toSet());
            }

            dto.setSales(allSalesInfo);

            customers.add(dto);
        }

        return customers;
    }

    /* Query 5 – Total Sales by Customer */

    @Override
    public Set<CustomerSalesDto> getAllWithAtLeastOneCarBought() {
        Set<Customer> allCustomers = this.customerRepository.findAllBySalesNotNull();

        List<CustomerSalesDto> dtos = new ArrayList<>();
        for (Customer customer : allCustomers) {
            CustomerSalesDto customerSalesDto = this.modelMapper.map(customer, CustomerSalesDto.class);
            customerSalesDto.setFullName(customer.getName());
            customerSalesDto.setBoughtCars(customer.getSales().size());
            customerSalesDto.setSpentMoney(customer.getMoneySpent());

            dtos.add(customerSalesDto);
        }

        Set<CustomerSalesDto> orderedDtos = dtos.stream().sorted((a, b) -> {
            int result = b.getSpentMoney().compareTo(a.getSpentMoney());

            if (result == 0) {
                result = Integer.compare(b.getBoughtCars(), a.getBoughtCars());
            }

            return result;
        }).collect(Collectors.toCollection(LinkedHashSet::new));
        return orderedDtos;
    }
}
