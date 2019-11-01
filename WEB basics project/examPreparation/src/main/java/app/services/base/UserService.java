package app.services.base;

import app.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel user);

    void update(UserServiceModel user);

    void unfriend(String id, String friendId);

    UserServiceModel getByUsernameAndPassword(String username, String password);

    UserServiceModel getByUsername(String username);

    UserServiceModel getById(String id);

    List<UserServiceModel> getAll();
}
