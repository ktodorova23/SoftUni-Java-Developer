package app.repositories.base;

import app.domain.entities.User;

import java.util.List;

public interface UserRepository {
    void save(User user);

    void update(User user);

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    User findById(String id);

    List<User> findAll();
}
