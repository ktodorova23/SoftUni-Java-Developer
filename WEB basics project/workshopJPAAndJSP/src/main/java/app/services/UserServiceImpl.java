package app.services;

import app.domain.entities.User;
import app.domain.models.UserLoginModel;
import app.domain.models.UserServiceModel;
import app.repositories.base.UserRepository;
import app.services.base.UserService;
import app.util.base.UserRegistrationValidator;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private static String LOGGED_IN_USER = "";

    private final UserRepository userRepository;
    private final UserRegistrationValidator userRegistrationValidator;

    @Inject
    UserServiceImpl(UserRepository userRepository,
                    UserRegistrationValidator userRegistrationValidator) {
        this.userRepository = userRepository;
        this.userRegistrationValidator = userRegistrationValidator;
    }


    @Override
    public void registerUser(UserServiceModel userModel) throws IllegalAccessException {
        if (!this.userRegistrationValidator.validData(userModel)) {
            throw new IllegalAccessException("Incorrect data entered!");
        } else {
            this.userRepository.createUser(userModel);
            LOGGED_IN_USER = userModel.getUsername();
        }
    }

    @Override
    public void loginUser(UserLoginModel userModel) throws IllegalAccessException {
        if (this.userRepository.login(userModel)) {
            LOGGED_IN_USER = userModel.getUsername();
        } else {
            throw new IllegalAccessException("There is no such user in database!");
        }
    }

    @Override
    public void logoutUser() {
        LOGGED_IN_USER = "";
    }

    @Override
    public User getLoggedInUser() throws IllegalAccessException {
        if (LOGGED_IN_USER.equals("")) {
            throw new IllegalAccessException("No Logged in user!");
        }
        return this.userRepository.getUserByUsername(LOGGED_IN_USER);
    }
}
