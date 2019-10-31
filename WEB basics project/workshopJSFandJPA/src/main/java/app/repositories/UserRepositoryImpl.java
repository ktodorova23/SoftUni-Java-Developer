package app.repositories;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;
import app.repositories.base.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(User user) {
        this.entityManager.getTransaction().begin();

        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        User user = this.entityManager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        return this.modelMapper.map(user, UserServiceModel.class);
    }
}
