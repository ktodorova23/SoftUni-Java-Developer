package app.services;

import app.domain.models.CarServiceModel;
import app.domain.models.CarViewModel;
import app.repositories.base.CarRepository;
import app.services.base.CarService;

import javax.inject.Inject;
import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Inject
    CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void createCar(CarServiceModel carModel) throws IllegalAccessException {
        this.carRepository.save(carModel);
    }

    @Override
    public List<CarViewModel> getAllCars() {
        return this.carRepository.getAll();
    }
}
