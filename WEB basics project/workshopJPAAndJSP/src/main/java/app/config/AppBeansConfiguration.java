package app.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AppBeansConfiguration {

    @Produces
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("workshop_db")
                .createEntityManager();
    }

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
