package app.services.base;

import app.domain.models.CarServiceModel;
import app.domain.models.CarViewModel;

import java.util.List;

public interface CarService {
    void createCar(CarServiceModel carModel) throws IllegalAccessException;

    List<CarViewModel> getAllCars();
}
