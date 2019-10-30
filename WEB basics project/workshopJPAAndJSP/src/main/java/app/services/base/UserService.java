package app.services.base;

import app.domain.entities.User;
import app.domain.models.UserLoginModel;
import app.domain.models.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userModel) throws IllegalAccessException;

    void loginUser(UserLoginModel userModel) throws IllegalAccessException;

    void logoutUser();

    User getLoggedInUser() throws IllegalAccessException;
}
