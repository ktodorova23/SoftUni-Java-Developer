package app.repositories;

import app.domain.entities.User;
import app.domain.models.UserLoginModel;
import app.domain.models.UserServiceModel;
import app.repositories.base.UserRepository;
import app.util.base.UserRegistrationValidator;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository {
    private static final String HASHING_MODEL = "!%s@";

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    UserRepositoryImpl(EntityManager entityManager,
                       ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createUser(UserServiceModel userModel) {
            User user = this.modelMapper.map(userModel, User.class);

            user.setPassword(this.hashPassword(userModel.getPassword()));

            this.entityManager.getTransaction().begin();
            this.entityManager.persist(user);
            this.entityManager.getTransaction().commit();
    }

    @Override
    public boolean login(UserLoginModel userModel) {
        User user = this.entityManager.createQuery("select u from User u where u.username =: username", User.class)
                .setParameter("username", userModel.getUsername()).getSingleResult();

        if (user == null) {
            return false;
        }

        if(!String.format(HASHING_MODEL, userModel.getPassword()).equals(user.getPassword())) {
            return false;
        }

        return true;
    }

    @Override
    public User getUserByUsername(String loggedInUser) {
        return this.entityManager.createQuery("select u from User u where u.username =: username", User.class)
                .setParameter("username", loggedInUser)
                .getSingleResult();
    }

    private String hashPassword(String password) {
        return String.format(HASHING_MODEL, password);
    }
}
