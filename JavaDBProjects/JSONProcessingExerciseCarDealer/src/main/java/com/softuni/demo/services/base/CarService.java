package com.softuni.demo.services.base;

import com.softuni.demo.domain.dtos.CarWithPartsDto;
import com.softuni.demo.domain.dtos.CarsFromMakeToyotaDto;

import java.io.IOException;
import java.util.List;

public interface CarService {
    void seedCars(String path) throws IOException;

    /* Query 2 – Cars from make Toyota */
    List<CarsFromMakeToyotaDto> carsFromMakeToyotaOrderedByModelAndTravelledDistance();

    /* Query 4 – Cars with Their List of Parts */
    List<CarWithPartsDto> getAllCarsWithParts();
}
