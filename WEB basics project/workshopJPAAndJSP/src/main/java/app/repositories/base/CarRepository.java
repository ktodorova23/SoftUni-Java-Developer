package app.repositories.base;

import app.domain.models.CarServiceModel;
import app.domain.models.CarViewModel;

import java.util.List;

public interface CarRepository {
    void save(CarServiceModel carModel) throws IllegalAccessException;

    List<CarViewModel> getAll();
}
