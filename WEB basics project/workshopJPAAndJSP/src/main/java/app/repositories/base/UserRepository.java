package app.repositories.base;

import app.domain.entities.User;
import app.domain.models.UserLoginModel;
import app.domain.models.UserServiceModel;

public interface UserRepository {
    void createUser(UserServiceModel userModel) throws IllegalAccessException;

    boolean login(UserLoginModel userModel);

    User getUserByUsername(String loggedInUser);
}
