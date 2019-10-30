package app.repositories;

import app.domain.entities.Car;
import app.domain.entities.enums.Engine;
import app.domain.models.CarServiceModel;
import app.domain.models.CarViewModel;
import app.repositories.base.CarRepository;
import app.services.base.UserService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepositoryImpl implements CarRepository {

    private final UserService userService;
    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    CarRepositoryImpl(UserService userService,
                      EntityManager entityManager,
                      ModelMapper modelMapper) {
        this.userService = userService;
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }
    @Override
    public void save(CarServiceModel carModel) throws IllegalAccessException {
        Car car = this.modelMapper.map(carModel, Car.class);

        car.setEngine(Engine.valueOf(carModel.getEngine()));

        this.entityManager.getTransaction().begin();
        car.setUser(this.userService.getLoggedInUser());
        this.entityManager.persist(car);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<CarViewModel> getAll() {
        List<Car> allCars = this.entityManager
                .createQuery("select c from Car c", Car.class)
                .getResultList();

         return allCars.stream()
                 .map(c -> this.modelMapper.map(c, CarViewModel.class))
                 .collect(Collectors.toList());
    }
}
