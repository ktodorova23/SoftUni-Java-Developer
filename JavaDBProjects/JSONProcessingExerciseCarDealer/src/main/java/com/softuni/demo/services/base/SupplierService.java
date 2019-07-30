package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.SupplierNotImportingDto;

import java.io.IOException;
import java.util.Set;

public interface SupplierService {
    void seedSuppliers(String path) throws IOException;

    /* Query 3 – Local Suppliers */
    Set<SupplierNotImportingDto> getLocalSuppliers();
}
