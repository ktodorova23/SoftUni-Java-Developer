package com.softuni.xmlprocessingcardealerhomework.services.base;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CarsFromMakeToyotaRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.CarsWithListOfPartsDto;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Car;

import javax.xml.bind.JAXBException;

public interface CarService {
    void seedCars() throws JAXBException;

    Car getRandomCar();

    /* Query 2 – Cars from make Toyota */
    CarsFromMakeToyotaRootDto carsFromMakeToyotaOrderedByModelAndTravelledDistance();

    CarsWithListOfPartsDto getAllCarsWithParts();
}
