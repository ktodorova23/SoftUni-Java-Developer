package com.softuni.xmlprocessingcardealerhomework.services.base;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.PartImportDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Part;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface PartService {
    void seedParts() throws JAXBException;

    List<Part> getRandomParts();
}
