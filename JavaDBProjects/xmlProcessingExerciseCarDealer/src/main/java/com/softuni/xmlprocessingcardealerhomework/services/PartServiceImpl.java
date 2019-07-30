package com.softuni.xmlprocessingcardealerhomework.services;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.PartImportDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.PartImportRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Part;
import com.softuni.xmlprocessingcardealerhomework.repositories.PartRepository;
import com.softuni.xmlprocessingcardealerhomework.services.base.PartService;
import com.softuni.xmlprocessingcardealerhomework.services.base.SupplierService;
import com.softuni.xmlprocessingcardealerhomework.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final static String PARTS_XML_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\inputs\\parts.xml";

    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, XmlParser xmlParser, ModelMapper modelMapper, Random random) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedParts() throws JAXBException {
        PartImportRootDto partImportRootDto = this.xmlParser.parseXml(PartImportRootDto.class, PARTS_XML_FILE_PATH);

        for (PartImportDto part : partImportRootDto.getParts()) {
            Part entity = this.modelMapper.map(part, Part.class);
            entity.setSupplier(this.supplierService.getRandomSupplierEntity());

            this.partRepository.saveAndFlush(entity);
        }
    }

    @Override
    public List<Part> getRandomParts() {
        int countParts = this.random.nextInt(11) + 10;

        List<Part> result = new ArrayList<>();
        int totalCount = (int) this.partRepository.count();
        for (int i = 0; i < countParts; i++) {
            int id = this.random.nextInt(totalCount - 1) + 1;
            result.add(this.partRepository.findById(id).get());
        }

        return result;
    }
}
