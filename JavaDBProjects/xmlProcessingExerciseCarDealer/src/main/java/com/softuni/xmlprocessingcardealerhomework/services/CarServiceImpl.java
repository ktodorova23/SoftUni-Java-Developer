package com.softuni.xmlprocessingcardealerhomework.services;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.CarImportDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.inputDtos.CarImportRootDto;
import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.*;
import com.softuni.xmlprocessingcardealerhomework.domain.entities.Car;
import com.softuni.xmlprocessingcardealerhomework.repositories.CarRepository;
import com.softuni.xmlprocessingcardealerhomework.services.base.CarService;
import com.softuni.xmlprocessingcardealerhomework.services.base.PartService;
import com.softuni.xmlprocessingcardealerhomework.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final static String CARS_XML_FILE_PATH = "E:\\Java\\DB Projects\\JavaDB\\xmlProcessingExerciseCarDealer\\src\\main\\resources\\inputs\\cars.xml";

    private final CarRepository carRepository;
    private final PartService partService;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, XmlParser xmlParser, ModelMapper modelMapper, Random random) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedCars() throws JAXBException {
        CarImportRootDto carImportRootDto = this.xmlParser.parseXml(CarImportRootDto.class, CARS_XML_FILE_PATH);

        for (CarImportDto car : carImportRootDto.getCars()) {

            Car entity = this.modelMapper.map(car, Car.class);
            entity.setParts(new HashSet<>(this.partService.getRandomParts()));

            this.carRepository.saveAndFlush(entity);
        }
    }

    @Override
    public Car getRandomCar() {
        int id = this.random.nextInt((int) this.carRepository.count() - 1) + 1;

        return this.carRepository.findById(id).get();
    }

    /* Query 2 – Cars from make Toyota */
    @Override
    public CarsFromMakeToyotaRootDto carsFromMakeToyotaOrderedByModelAndTravelledDistance() {
        List<Car> toyotas = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc("Toyota");

        List<CarsFromMakeToyotaDto> dtos = new ArrayList<>();

        for (Car car : toyotas) {
            dtos.add(this.modelMapper.map(car, CarsFromMakeToyotaDto.class));
        }

        CarsFromMakeToyotaRootDto carsFromMakeToyotaRootDto = new CarsFromMakeToyotaRootDto();
        carsFromMakeToyotaRootDto.setCars(dtos);

        return carsFromMakeToyotaRootDto;
    }

    @Override
    public CarsWithListOfPartsDto getAllCarsWithParts() {
        List<Car> allCars = this.carRepository.findAll();

        List<CarSimpleDto> dtos = new ArrayList<>();

        for (Car car : allCars) {
            CarSimpleDto dto = this.modelMapper.map(car, CarSimpleDto.class);

            Set<PartSimpleDto> partsMapped = car.getParts()
                    .stream()
                    .map(p -> this.modelMapper.map(p, PartSimpleDto.class))
                    .collect(Collectors.toSet());

            dto.setParts(partsMapped);

            dtos.add(dto);
        }

        CarsWithListOfPartsDto carsWithListOfPartsDto = new CarsWithListOfPartsDto();
        carsWithListOfPartsDto.setCars(dtos);

        return carsWithListOfPartsDto;
    }
}
