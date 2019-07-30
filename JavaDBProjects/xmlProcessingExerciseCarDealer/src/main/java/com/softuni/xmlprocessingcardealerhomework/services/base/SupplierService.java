package com.softuni.xmlprocessingcardealerhomework.services.base;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.LocalSupplierRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Supplier;

import javax.xml.bind.JAXBException;

public interface SupplierService {
    void seedSuppliers() throws JAXBException;

    Supplier getRandomSupplierEntity();

    /* Query 3 – Local Suppliers */
    LocalSupplierRootDto getLocalSuppliers();
}
