package com.softuni.xmlprocessingcardealerhomework.services;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.SupplierImportDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.SupplierImportRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.LocalSupplierDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.LocalSupplierRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Supplier;
import com.softuni.xmlprocessingcardealerhomework.repositories.SupplierRepository;
import com.softuni.xmlprocessingcardealerhomework.services.base.SupplierService;
import com.softuni.xmlprocessingcardealerhomework.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final static String SUPPLIERS_XML_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\inputs\\suppliers.xml";

    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, XmlParser xmlParser, ModelMapper modelMapper, Random random) {
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedSuppliers() throws JAXBException {
        SupplierImportRootDto supplierImportRootDto = this.xmlParser.parseXml(SupplierImportRootDto.class, SUPPLIERS_XML_FILE_PATH);

        for (SupplierImportDto supplier : supplierImportRootDto.getSuppliers()) {
            Supplier entity = this.modelMapper.map(supplier, Supplier.class);

            this.supplierRepository.saveAndFlush(entity);
        }
    }

    @Override
    public Supplier getRandomSupplierEntity() {
        int id = this.random.nextInt((int) (this.supplierRepository.count()) - 1) + 1;

        return this.supplierRepository.findById(id).get();
    }

    /* Query 3 – Local Suppliers */
    @Override
    public LocalSupplierRootDto getLocalSuppliers() {
        Set<Supplier> allSuppliers = this.supplierRepository.findAllByImporterIsFalse();

        List<LocalSupplierDto> dtos = new ArrayList<>();

        for (Supplier supplier : allSuppliers) {
            LocalSupplierDto dto = this.modelMapper.map(supplier, LocalSupplierDto.class);
            dto.setPartsCount(supplier.getParts().size());

            dtos.add(dto);
        }

        LocalSupplierRootDto localSupplierRootDto = new LocalSupplierRootDto();
        localSupplierRootDto.setSuppliers(dtos);

        return localSupplierRootDto;
    }
}
