package com.softuni.xmlprocessingcardealerhomework.services;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.CustomerImportDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.CustomerImportRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CustomerOrderedDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CustomerOrderedRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CustomersDataDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CustomerSalesDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Customer;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Sale;
import com.softuni.xmlprocessingcardealerhomework.repositories.CustomerRepository;
import com.softuni.xmlprocessingcardealerhomework.services.base.CustomerService;
import com.softuni.xmlprocessingcardealerhomework.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final static String CUSTOMERS_XML_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\inputs\\customers.xml";

    private final CustomerRepository customerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, XmlParser xmlParser, ModelMapper modelMapper, Random random) {
        this.customerRepository = customerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedCustomers() throws JAXBException {
        CustomerImportRootDto customerImportRootDto = this.xmlParser.parseXml(CustomerImportRootDto.class, CUSTOMERS_XML_FILE_PATH);

        for (CustomerImportDto customer : customerImportRootDto.getCustomers()) {
            Customer entity = this.modelMapper.map(customer, Customer.class);
            entity.setBirthDate(LocalDate.parse(customer.getBirthDate()));
            this.customerRepository.saveAndFlush(entity);
        }
    }

    @Override
    public Customer getRandomCustomer() {
        int id = this.random.nextInt((int) this.customerRepository.count() - 1) + 1;

        return this.customerRepository.findById(id).get();
    }

    /* Query 1 – Ordered Customers */
    @Override
    public CustomerOrderedRootDto orderedCustomers() {
        Set<Customer> allCustomersOrdered = this.customerRepository.findAllOrderedByBirthDate();

        List<CustomerOrderedDto> dtos = new ArrayList<>();
        for (Customer customer : allCustomersOrdered) {
            CustomerOrderedDto dto = this.modelMapper.map(customer, CustomerOrderedDto.class);

            dtos.add(dto);
        }

        CustomerOrderedRootDto customerOrderedRootDto = new CustomerOrderedRootDto();
        customerOrderedRootDto.setCustomers(dtos);

        return customerOrderedRootDto;
    }

    @Override
    public CustomerSalesDto getAllWithAtLeastOneCarBought() {
        Set<Customer> allCustomers = this.customerRepository.findAllBySalesNotNull();

        List<CustomersDataDto> dtos = new ArrayList<>();

        for (Customer customer : allCustomers) {
            CustomersDataDto dto = this.modelMapper.map(customer, CustomersDataDto.class);
            dto.setBoughtCars(customer.getSales().size());
            dto.setSpentMoney(customer.getMoneySpent());

            dtos.add(dto);
        }

        CustomerSalesDto customerSalesDto = new CustomerSalesDto();
        customerSalesDto.setCustomers(dtos);
        return customerSalesDto;
    }
}
