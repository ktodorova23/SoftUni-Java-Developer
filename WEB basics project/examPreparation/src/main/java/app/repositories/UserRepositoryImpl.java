package app.repositories;

import app.domain.entities.User;
import app.repositories.base.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(user);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return this.entityManager
                .createQuery("select u from User u where u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        return this.entityManager
                .createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public User findById(String id) {
        return this.entityManager
                .createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> findAll() {
        return this.entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
    }
}
