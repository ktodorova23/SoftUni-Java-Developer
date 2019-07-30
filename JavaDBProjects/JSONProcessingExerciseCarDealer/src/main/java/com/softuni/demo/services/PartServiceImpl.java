package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.PartSeedDto;
import com.softuni.demo.domain.entities.Part;
import com.softuni.demo.domain.entities.Supplier;
import com.softuni.demo.repositories.PartRepository;
import com.softuni.demo.repositories.SupplierRepository;
import com.softuni.demo.services.base.PartService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Random;


@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final FileUtil fileUtil;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;

    @Autowired
    public PartServiceImpl(FileUtil fileUtil, ValidatorUtil validatorUtil, Gson gson, ModelMapper modelMapper, SupplierRepository supplierRepository, PartRepository partRepository) {
        this.fileUtil = fileUtil;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
    }

    @Override
    public void seedParts(String path) throws IOException {
        String content = this.fileUtil.fileContent(path);

        PartSeedDto[] partSeedDtos = this.gson.fromJson(content, PartSeedDto[].class);

        for (PartSeedDto partSeedDto : partSeedDtos) {
            if (!this.validatorUtil.isValid(partSeedDto)) {
                this.validatorUtil.validate(partSeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            partSeedDto.setSupplier(this.getRandomSupplier());
            Part part = this.modelMapper.map(partSeedDto, Part.class);

            this.partRepository.saveAndFlush(part);
        }
    }

    private Supplier getRandomSupplier() {
        Random random = new Random();

        int id = random.nextInt((int) this.supplierRepository.count()) + 1;
        return this.supplierRepository.findById(id).get();
    }
}
