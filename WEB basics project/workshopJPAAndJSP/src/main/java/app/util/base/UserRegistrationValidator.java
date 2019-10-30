package app.util.base;

import app.domain.models.UserServiceModel;

public interface UserRegistrationValidator {
    boolean validData(UserServiceModel userModel);
}
