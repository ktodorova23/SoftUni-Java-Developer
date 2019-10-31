package app.repositories.base;

import app.domain.entities.User;
import app.domain.models.service.UserServiceModel;

public interface UserRepository {
    void save(User user);

    UserServiceModel findByUsername(String username);
}
