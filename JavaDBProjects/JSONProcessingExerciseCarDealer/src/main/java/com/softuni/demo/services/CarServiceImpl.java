package com.softuni.demo.services;

import com.google.gson.Gson;
import com.softuni.demo.domain.dtos.*;
import com.softuni.demo.domain.entities.Car;
import com.softuni.demo.domain.entities.Part;
import com.softuni.demo.repositories.CarRepository;
import com.softuni.demo.repositories.PartRepository;
import com.softuni.demo.services.base.CarService;
import com.softuni.demo.utils.FileUtil;
import com.softuni.demo.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(FileUtil fileUtil, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper, PartRepository partRepository, CarRepository carRepository) {
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void seedCars(String path) throws IOException {
        String content = this.fileUtil.fileContent(path);

        CarSeedDto[] carSeedDtos = this.gson.fromJson(content, CarSeedDto[].class);

        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (!this.validatorUtil.isValid(carSeedDto)) {
                this.validatorUtil.validate(carSeedDto).forEach(v -> System.out.println(v.getMessage()));

                continue;
            }
            carSeedDto.setParts(this.getRandomNumberOfParts());
            Car car = this.modelMapper.map(carSeedDto, Car.class);

            this.carRepository.saveAndFlush(car);
        }
    }

    private Set<Part> getRandomNumberOfParts() {
        Set<Part> parts = new LinkedHashSet<>();
        Random random = new Random();

        int countOfParts = random.nextInt(11) + 10;

        for (int i = 0; i < countOfParts; i++) {
            parts.add(this.getRandomPart());
        }

        return parts;
    }

    private Part getRandomPart() {
        Random random = new Random();

        int id = random.nextInt((int) (this.partRepository.count())) + 1;
        return this.partRepository.findById(id).get();
    }

    /* Query 2 – Cars from make Toyota */
    @Override
    public List<CarsFromMakeToyotaDto> carsFromMakeToyotaOrderedByModelAndTravelledDistance() {
        List<Car> cars = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc("Toyota");

        return cars.stream().map(c -> this.modelMapper.map(c, CarsFromMakeToyotaDto.class)).collect(Collectors.toList());
    }

    /* Query 4 – Cars with Their List of Parts */
    @Override
    public List<CarWithPartsDto> getAllCarsWithParts() {
        List<Car> allCars = this.carRepository.findAll();

        List<CarWithPartsDto> mappedInformation = new ArrayList<>();

        for (Car car : allCars) {
            CarInformationDto mappedCar = this.modelMapper.map(car, CarInformationDto.class);

            Set<PartCommonInfoDto> mappedParts = car.getParts()
                    .stream()
                    .map(p -> this.modelMapper.map(p, PartCommonInfoDto.class))
                    .collect(Collectors.toSet());

            CarWithPartsDto carWithPartsDto = new CarWithPartsDto();
            carWithPartsDto.setCar(mappedCar);
            carWithPartsDto.setParts(mappedParts);

            mappedInformation.add(carWithPartsDto);
        }

        return mappedInformation;
    }
}
