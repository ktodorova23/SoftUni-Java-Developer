package app.services.base;

import app.domain.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findUser(String username);
}
