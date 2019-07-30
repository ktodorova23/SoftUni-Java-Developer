package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.SupplierNotImportingDto;
import com.softuni.demo.domain.dtos.SupplierSeedDto;
import com.softuni.demo.domain.entities.Supplier;
import com.softuni.demo.repositories.SupplierRepository;
import com.softuni.demo.services.base.SupplierService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final FileUtil fileUtil;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(FileUtil fileUtil, ValidatorUtil validatorUtil, Gson gson, ModelMapper modelMapper, SupplierRepository supplierRepository) {
        this.fileUtil = fileUtil;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedSuppliers(String path) throws IOException {
        String content = this.fileUtil.fileContent(path);

        SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(content, SupplierSeedDto[].class);

        for (SupplierSeedDto supplierSeedDto : supplierSeedDtos) {
            if (!this.validatorUtil.isValid(supplierSeedDto)) {
                this.validatorUtil.validate(supplierSeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            Supplier supplier = this.modelMapper.map(supplierSeedDto, Supplier.class);

            this.supplierRepository.saveAndFlush(supplier);
        }
    }

     /* Query 3 – Local Suppliers */
    @Override
    public Set<SupplierNotImportingDto> getLocalSuppliers() {
        Set<Supplier> allLocalSuppliers = this.supplierRepository.findAllByImporterIsFalse();

        Set<SupplierNotImportingDto> mappedSuppliers = new LinkedHashSet<>();

        for (Supplier supplier : allLocalSuppliers) {
            SupplierNotImportingDto dto = this.modelMapper.map(supplier, SupplierNotImportingDto.class);

            dto.setPartsCount(supplier.getParts().size());
            mappedSuppliers.add(dto);
        }

        return mappedSuppliers;
    }
}
